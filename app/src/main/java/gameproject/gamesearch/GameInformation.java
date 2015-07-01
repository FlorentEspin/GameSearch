package gameproject.gamesearch;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import gameproject.gamesearch.recyclerview.ListEditorAdaptator;
import gameproject.gamesearch.recyclerview.ListKingAdaptator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class GameInformation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_information);
        // Ajout police
        final Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/arcade.ttf");

        Create request = new Create();
        final CRUD api=   request.getApiService();

        String ID ="";
        Bundle extras = getIntent().getExtras();
        final RecyclerView recyclerViewGenre = (RecyclerView) findViewById(R.id.recyclerViewGameInformationGenre);
        recyclerViewGenre.setLayoutManager(new LinearLayoutManager(this));

        final RecyclerView recyclerViewEditeur = (RecyclerView) findViewById(R.id.recyclerViewGameInformationEditeur);
        recyclerViewEditeur.setLayoutManager(new LinearLayoutManager(this));


        if (extras != null) {
            ID = getIntent().getStringExtra("ID");
            try {
                api.getGameById(Integer.parseInt(ID), new Callback<Jeu>() {
                    @Override
                    public void success(Jeu jeux, Response response) {

                        //ADD ID
                        TextView tbID = (TextView) findViewById(R.id.tbIDJeu);
                        tbID.setText(String.valueOf(jeux.getIdJeu()));
                        tbID.setTypeface(custom_font);
                        //ADD NAME
                        EditText tbGameName = (EditText) findViewById(R.id.tbNomJeu);
                        tbGameName.setText(jeux.getNomJeu());
                        tbGameName.setTypeface(custom_font);

                        // Label ID JEU
                        TextView lblID = (TextView) findViewById(R.id.lblIDJeu);
                        lblID.setTypeface(custom_font);

                        // Label NOM JEU
                        TextView lblNomJeu = (TextView) findViewById(R.id.lblNomJeu);
                        lblNomJeu.setTypeface(custom_font);

                        // Label EDITEUR JEU
                        TextView lblEditeurJeu = (TextView) findViewById(R.id.lblEditeurJeu);
                        lblEditeurJeu.setTypeface(custom_font);

                        // Label DATE JEU
                        TextView lblDateJeu = (TextView) findViewById(R.id.lblDateJeu);
                        lblDateJeu.setTypeface(custom_font);

                        // Label GENRE JEU
                        TextView lblGenreJeu = (TextView) findViewById(R.id.lblGenreJeu);
                        lblGenreJeu.setTypeface(custom_font);

                        ListKingAdaptator mAdapterGenre = new ListKingAdaptator(jeux.getGenre());
                        recyclerViewGenre.setAdapter(mAdapterGenre);
                        recyclerViewGenre.setItemAnimator(new DefaultItemAnimator());

                        ListEditorAdaptator mAdapterEditeur = new ListEditorAdaptator(jeux.getEditeur());
                        recyclerViewEditeur.setAdapter(mAdapterEditeur);
                        recyclerViewEditeur.setItemAnimator(new DefaultItemAnimator());
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
            catch(Exception e)
            {

            }
        }
        final String userID = getIntent().getStringExtra("ID");
        final Button btnModify = (Button) findViewById(R.id.btnKindModify);
        btnModify.setTypeface(custom_font);
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jeu modifiedGame = new Jeu();//Integer.parseInt(userID), ((EditText) findViewById(R.id.tbEditorName)).getText().toString());
                api.UpdateGame(modifiedGame, new Callback<Jeu>() {
                    @Override
                    public void success(Jeu jeu, Response response) {

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });

            }
        });
        final Button btnDelete = (Button) findViewById(R.id.btnSupprimerJeu);
        btnDelete.setTypeface(custom_font);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userID != "" && userID != null) {
                    api.deleteGame(Integer.parseInt(userID), new Callback<String>() {
                        @Override
                        public void success(String s, Response response) {

                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_information, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

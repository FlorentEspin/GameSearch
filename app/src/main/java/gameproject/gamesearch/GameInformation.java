package gameproject.gamesearch;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import gameproject.gamesearch.recyclerview.ListEditorAdaptator;
import gameproject.gamesearch.recyclerview.ListKindAdaptator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class GameInformation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_information);
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
                        //ADD NAME
                        EditText tbGameName = (EditText) findViewById(R.id.tbNomJeu);
                        tbGameName.setText(jeux.getNomJeu());

                        DatePicker dtpJeu = (DatePicker) findViewById(R.id.dtpDateSortieJeu);
                        if(!jeux.getDateDeSortieJeu().equals("")) {
                            String[] parts = jeux.getDateDeSortieJeu().split("-");
                            String[] parts2=  parts[2].split("T");
                            dtpJeu.init(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts2[0]),null);
                        }

                        ListKindAdaptator mAdapterGenre = new ListKindAdaptator(jeux.getGenre());
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
                final Button btnCreate = (Button) findViewById(R.id.btnAddEditeurGameInformation);
                //       btnCreateUser.setTypeface(custom_font);
                btnCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intentJeux = new Intent(v.getContext(),EditorForGame.class);
                            String testValue= ((TextView) findViewById(R.id.tbIDJeu)).getText().toString();
                            intentJeux.putExtra("ID", ((TextView)findViewById(R.id.tbIDJeu)).getText().toString());
                           v.getContext().startActivity(intentJeux);
                        } catch (Exception e) {
                            e.toString();
                        }
                    }
                });
            }
            catch(Exception e)
            {

            }
        }
        final String userID = getIntent().getStringExtra("ID");
        final Button btnModify = (Button) findViewById(R.id.btnKindModifyKindInformation);
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

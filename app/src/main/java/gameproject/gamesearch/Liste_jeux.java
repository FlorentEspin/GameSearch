package gameproject.gamesearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gameproject.gamesearch.recyclerview.ListGameAdaptator;
import gameproject.gamesearch.recyclerview.ListUserAdaptator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class Liste_jeux extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_jeux);
        TextView titre = (TextView)findViewById(R.id.titre);
        Create request = new Create();
        final CRUD api=   request.getApiService();
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/arcade.ttf");
        titre.setTypeface(custom_font);
//

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGame);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            api.getAllGames(new Callback<ArrayList<Jeu>>() {
                @Override
                public void success(ArrayList<Jeu> jeus, Response response) {
                    ListGameAdaptator mAdapter = new ListGameAdaptator(jeus);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });
            //Add event on buttons
            final Button btnReinitialiser = (Button) findViewById(R.id.btnReinitialiserJeu);
            btnReinitialiser.setTypeface(custom_font);
            btnReinitialiser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    api.getAllGames(new Callback<ArrayList<Jeu>>() {
                        @Override
                        public void success(ArrayList<Jeu> Jeu, Response response) {
                            ListGameAdaptator mAdapter = new ListGameAdaptator(Jeu);
                            recyclerView.setAdapter(mAdapter);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });
                }
            });


            final Button btnFindUser = (Button) findViewById(R.id.btnRechercherJeu);
            btnFindUser.setTypeface(custom_font);
            btnFindUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final List<Jeu> jeux = new ArrayList<Jeu>();
                 //   if(((EditText) findViewById(R.id.tbNomJeu)).getText().toString()!= "" && ((EditText) findViewById(R.id.tbUserName)).getText().toString()!= null)
                        api.getGameByName(((EditText) findViewById(R.id.tbRechercheJeu)).getText().toString(), new Callback<Jeu>() {
                            @Override
                            public void success(Jeu Jeu, Response response) {

                                jeux.add(Jeu);
                                ListGameAdaptator mAdapter = new ListGameAdaptator(jeux);
                                recyclerView.setAdapter(mAdapter);
                                recyclerView.setItemAnimator(new DefaultItemAnimator());
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                //create a toast to notify that the user has not found
                                Context context = v.getContext();
                                CharSequence text = (CharSequence) "Jeu non trouvé";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                        });
                }
            });

            final Button btnCreateUser = (Button) findViewById(R.id.btnCreateGame);
            btnCreateUser.setTypeface(custom_font);
            btnCreateUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Context context = v.getContext();
                        Intent intentUtilisateurs = new Intent(v.getContext(), CreateUser.class);
                        context.startActivity(intentUtilisateurs);
                    } catch (Exception e) {
                        e.toString();
                    }
                }
            });

        }
        catch (Exception e)
        {e.toString();}

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_liste_jeux, menu);
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

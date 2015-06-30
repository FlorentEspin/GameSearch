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


import gameproject.gamesearch.recyclerview.ListUserAdaptator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class Liste_utilisateurs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_utilisateurs);

        TextView titre = (TextView)findViewById(R.id.titre);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/arcade.ttf");
        titre.setTypeface(custom_font);

        Create request = new Create();
        final CRUD api=   request.getApiService();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
           api.getAllUser(new Callback<ArrayList<Utilisateur>>() {
               @Override
               public void success(ArrayList<Utilisateur> utilisateurs, Response response) {
                   ListUserAdaptator mAdapter = new ListUserAdaptator(utilisateurs);
                   recyclerView.setAdapter(mAdapter);
                   recyclerView.setItemAnimator(new DefaultItemAnimator());
               }

               @Override
               public void failure(RetrofitError error) {

               }
           });


            //Add event on buttons
            final Button btnReinitialiser = (Button) findViewById(R.id.btnReinitialiser);
            btnReinitialiser.setTypeface(custom_font);
            btnReinitialiser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    api.getAllUser(new Callback<ArrayList<Utilisateur>>() {
                        @Override
                        public void success(ArrayList<Utilisateur> utilisateurs, Response response) {
                            ListUserAdaptator mAdapter = new ListUserAdaptator(utilisateurs);
                            recyclerView.setAdapter(mAdapter);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });
                }
            });


            final Button btnFindUser = (Button) findViewById(R.id.btnRechercher);
            btnFindUser.setTypeface(custom_font);
            btnFindUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final List<Utilisateur> users = new ArrayList<Utilisateur>();
                    if(((EditText) findViewById(R.id.tbGameName)).getText().toString()!= "" && ((EditText) findViewById(R.id.tbGameName)).getText().toString()!= null)
                    api.getUserByName(((EditText) findViewById(R.id.tbGameName)).getText().toString(), new Callback<Utilisateur>() {
                        @Override
                        public void success(Utilisateur utilisateur, Response response) {

                            users.add(utilisateur);
                            ListUserAdaptator mAdapter = new ListUserAdaptator(users);
                            recyclerView.setAdapter(mAdapter);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            //create a toast to notify that the user has not found
                            Context context = v.getContext();
                            CharSequence text = (CharSequence) "Utilsateur non trouvé";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    });
                }
            });

            final Button btnCreateUser = (Button) findViewById(R.id.btnCreateUser);
            btnCreateUser.setTypeface(custom_font);
            btnCreateUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Context context = v.getContext();
                        Intent intentUtilisateurs = new Intent(context, CreateUser.class);
                        context.startActivity(intentUtilisateurs);
                    }
                    catch (Exception e)
                    {
                    e.toString();
                    }
                }
            });

        }
        catch (Exception e)
        {
            e.toString();
        }

        //allUser.add(new Utilisateur(1,"1","1"));
        //allUser.add(new Utilisateur(1,"2","2"));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_liste_utilisateurs, menu);
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

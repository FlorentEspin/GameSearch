package gameproject.gamesearch;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gameproject.gamesearch.recyclerview.ListKindAdaptator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class List_Genre extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_genre);


        Create request = new Create();
        final CRUD api=   request.getApiService();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGenre);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {

            api.getAllKind(new Callback<ArrayList<Genre>>() {
                @Override
                public void success(ArrayList<Genre> genres, Response response) {
                    ListKindAdaptator mAdapter = new ListKindAdaptator(genres);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });

            //Add event on buttons
            final Button btnReinitialiser = (Button) findViewById(R.id.btnReinitialiserGenre);
            //   btnReinitialiser.setTypeface(custom_font);
            btnReinitialiser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    api.getAllKind(new Callback<ArrayList<Genre>>() {
                        @Override
                        public void success(ArrayList<Genre> Genre, Response response) {
                            ListKindAdaptator mAdapter = new ListKindAdaptator(Genre);
                            recyclerView.setAdapter(mAdapter);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });
                }
            });


            final Button btnFindUser = (Button) findViewById(R.id.btnRechercheGenre);
            //     btnFindUser.setTypeface(custom_font);
            btnFindUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final List<Genre> Genres = new ArrayList<Genre>();
                    //   if(((EditText) findViewById(R.id.tbNomJeu)).getText().toString()!= "" && ((EditText) findViewById(R.id.tbUserName)).getText().toString()!= null)
                    api.getKindByName(((EditText) findViewById(R.id.tbRechercheGenre)).getText().toString(), new Callback<Genre>() {
                        @Override
                        public void success(Genre Genre, Response response) {

                            Genres.add(Genre);
                            ListKindAdaptator mAdapter = new ListKindAdaptator(Genres);
                            recyclerView.setAdapter(mAdapter);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            //create a toast to notify that the user has not found
                            Context context = v.getContext();
                            CharSequence text = (CharSequence) "Utilsateur non trouve";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    });
                }
            });


            final Button btnCreate = (Button) findViewById(R.id.btnCreerListGenre);
            btnCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Context context = v.getContext();
                        Intent intentUtilisateurs = new Intent(v.getContext(), CreateGenre.class);
                        context.startActivity(intentUtilisateurs);

                }
            });

        }
        catch (Exception e){
            e.toString();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list__genre, menu);
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

package gameproject.gamesearch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class AddGenreToGame extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_genre_to_game);
        Create request = new Create();
        final CRUD api=  request.getApiService();


        final Button btnCreate = (Button) findViewById(R.id.btnIDGenreAddGenreToGame);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String IDjeu ="";
                Bundle extras = getIntent().getExtras();
                final Context context = v.getContext();
                CharSequence text = (CharSequence) "Genre ajouté";
                int duration = Toast.LENGTH_SHORT;
                final Toast toast = Toast.makeText(context, text, duration);
                if (extras != null) {
                    final Jeu[] jeuToUpdate = {new Jeu()};
                    IDjeu = getIntent().getStringExtra("IDJEU");
                    final String IDEditor = getIntent().getStringExtra("ID");
                    try {
                        api.getGameById(Integer.parseInt(IDjeu), new Callback<Jeu>() {
                            @Override
                            public void success(final Jeu jeu, Response response) {
                                final List<Genre> lesGenreDuJeu = jeu.getGenre();
                                api.getKindById(Integer.parseInt(IDEditor), new Callback<Genre>() {
                                    @Override
                                    public void success(Genre Genre, Response response) {
                                        lesGenreDuJeu.add(Genre);
                                        jeu.Genre = lesGenreDuJeu;
                                        jeuToUpdate[0] = jeu;
                                        TextView tbGameName = (TextView) findViewById(R.id.tbIDGenreAddGenreToGame);
                                        tbGameName.setText(Genre.getNomGenre());
                                        api.UpdateGame(jeu, new Callback<Jeu>() {
                                            @Override
                                            public void success(Jeu jeu, Response response) {
                                                Intent intentJeux = new Intent(context, GameInformation.class);
                                                intentJeux.putExtra("ID", getIntent().getStringExtra("IDJEU"));
                                                context.startActivity(intentJeux);
                                                toast.show();
                                            }

                                            @Override
                                            public void failure(RetrofitError error) {
                                                Intent intentJeux = new Intent(context, GameInformation.class);
                                                intentJeux.putExtra("ID", getIntent().getStringExtra("IDJEU"));
                                                context.startActivity(intentJeux);
                                                toast.show();
                                            }
                                        });
                                    }

                                    @Override
                                    public void failure(RetrofitError error) {

                                    }
                                });
                            }

                            @Override
                            public void failure(RetrofitError error) {
                            }
                        });

                    }
                    catch (Exception e)
                    {}
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_genre_to_game, menu);
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

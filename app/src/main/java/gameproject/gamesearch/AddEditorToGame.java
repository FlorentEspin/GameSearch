package gameproject.gamesearch;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class AddEditorToGame extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_editor_to_game);
        Create request = new Create();
        final CRUD api=  request.getApiService();
        String IDjeu ="";
        Bundle extras = getIntent().getExtras();



        if (extras != null) {
            final Jeu[] jeuToUpdate = {new Jeu()};
            IDjeu = getIntent().getStringExtra("IDJEU");
        final String    IDEditor = getIntent().getStringExtra("ID");
            try {
                api.getGameById(Integer.parseInt(IDjeu), new Callback<Jeu>() {
                    @Override
                    public void success(final Jeu jeu, Response response) {
                        final List<Editeur> lesEditeurDuJeu = jeu.getEditeur();
                        api.getEditorById(Integer.parseInt(IDEditor), new Callback<Editeur>() {
                            @Override
                            public void success(Editeur editeur, Response response) {
                                lesEditeurDuJeu.add(editeur);
                                jeu.Editeur = lesEditeurDuJeu;
                                jeuToUpdate[0] = jeu;
                                api.UpdateGame(jeuToUpdate[0], new Callback<Jeu>() {
                                    @Override
                                    public void success(Jeu jeu, Response response) {

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

                    @Override
                    public void failure(RetrofitError error) {

                    }

                });



            }

    catch (Exception e)
            {}
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_editor_to_game, menu);
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

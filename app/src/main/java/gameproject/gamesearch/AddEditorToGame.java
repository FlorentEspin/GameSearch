package gameproject.gamesearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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

        final Button btnCreate = (Button) findViewById(R.id.btnAddEditorAddEditorToGame);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v)
            {
                Bundle extras = getIntent().getExtras();
                String IDjeu ="";
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
                                        TextView tbGameName = (TextView) findViewById(R.id.tbEditorNameAddEditorToGame);
                                        tbGameName.setText(editeur.getNom());
                                        api.UpdateGame(jeu, new Callback<Jeu>() {
                                            @Override
                                            public void success(Jeu jeu, Response response) {
                                                Context context = v.getContext();
                                                CharSequence text = (CharSequence) "Editeur ajouté";
                                                int duration = Toast.LENGTH_SHORT;
                                                Toast toast = Toast.makeText(context, text, duration);
                                                Intent intentJeux = new Intent(context,GameInformation.class);
                                                intentJeux.putExtra("ID",getIntent().getStringExtra("IDJEU"));
                                                context.startActivity(intentJeux);
                                                toast.show();
                                            }
                                            @Override
                                            public void failure(RetrofitError error) {
                                                Context context = v.getContext();
                                                CharSequence text = (CharSequence) "Editeur ajouté";
                                                int duration = Toast.LENGTH_SHORT;
                                                Toast toast = Toast.makeText(context, text, duration);
                                                Intent intentJeux = new Intent(context,GameInformation.class);
                                                intentJeux.putExtra("ID",getIntent().getStringExtra("IDJEU"));
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

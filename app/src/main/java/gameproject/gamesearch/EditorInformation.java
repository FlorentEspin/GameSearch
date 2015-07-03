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
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gameproject.gamesearch.recyclerview.ListGameAdaptator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class EditorInformation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_information);
        Create request = new Create();
        final CRUD api=   request.getApiService();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGameEditorEditorInformation);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String ID ="";
        Bundle extras = getIntent().getExtras();



        if (extras != null) {
            ID = getIntent().getStringExtra("ID");
            try {
                api.getEditorById(Integer.parseInt(ID), new Callback<Editeur>() {
                    @Override
                    public void success(Editeur editeur, Response response) {

                        //ADD ID
                        TextView tbID = (TextView) findViewById(R.id.tbIDEditorInformation);
                        tbID.setText(String.valueOf(editeur.getId()));
                        //ADD NAME
                        EditText tbLogin = (EditText) findViewById(R.id.tbEditorNameEditorInformation);
                        tbLogin.setText(editeur.getNom());
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });


                if (extras != null) {
                 final String IDEditeur = getIntent().getStringExtra("ID");
                    final List<Jeu> lesJeux = new ArrayList<Jeu>();
                   api.getAllGames(new Callback<ArrayList<Jeu>>() {
                       @Override
                       public void success(ArrayList<Jeu> jeus, Response response) {
                           Iterator<Jeu> j = jeus.iterator();
                           while (j.hasNext())
                           {
                               boolean needAdd=false;
                               Jeu jeu = j.next();
                               Iterator<Editeur> e = jeu.getEditeur().iterator();
                               while (e.hasNext())
                               {
                                  Editeur editeur =  e.next();
                                   if(IDEditeur.toString().equals(String.valueOf(editeur.getId())))
                                   {
                                        needAdd=true;
                                   }
                               }
                               if(needAdd)lesJeux.add(jeu);

                           }
                           ListGameAdaptator mAdapter = new ListGameAdaptator(lesJeux);
                           recyclerView.setAdapter(mAdapter);
                           recyclerView.setItemAnimator(new DefaultItemAnimator());

                       }


                       @Override
                       public void failure(RetrofitError error) {

                       }
                   });
            }}
            catch(Exception e)
            {

            }
        }
        final String userID = getIntent().getStringExtra("ID");
        final Button btnModify = (Button) findViewById(R.id.btnModifierEditorEditorInformation);
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Editeur modifiedUser = new Editeur(Integer.parseInt(userID), ((EditText) findViewById(R.id.tbEditorNameEditorInformation)).getText().toString());
                api.updateEditor(modifiedUser, new Callback<Editeur>() {
                    @Override
                    public void success(Editeur utilisateur, Response response) {
                        Intent intentGenre = new Intent(v.getContext(), Liste_Editor.class);
                        startActivity(intentGenre);

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });

            }
        });
        final Button btnDelete = (Button) findViewById(R.id.btnSupprimerEditorEditorInformation);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (userID != "" && userID != null) {
                    api.deleteEditor(Integer.parseInt(userID), new Callback<String>() {
                        @Override
                        public void success(String s, Response response) {
                            Intent intentGenre = new Intent(v.getContext(), Liste_Editor.class);
                            startActivity(intentGenre);

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
        getMenuInflater().inflate(R.menu.menu_editor_information, menu);
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

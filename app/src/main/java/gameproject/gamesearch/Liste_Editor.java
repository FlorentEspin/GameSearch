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

import gameproject.gamesearch.recyclerview.CreateEditor;
import gameproject.gamesearch.recyclerview.ListEditorAdaptator;
import gameproject.gamesearch.recyclerview.ListGameAdaptator;
import gameproject.gamesearch.recyclerview.ListUserAdaptator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class Liste_Editor extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste__editor);

        Create request = new Create();
        final CRUD api=   request.getApiService();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewEditor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {

            api.getAllEditor(new Callback<ArrayList<Editeur>>() {
                @Override
                public void success(ArrayList<Editeur> editeurs, Response response) {
                    ListEditorAdaptator mAdapter = new ListEditorAdaptator(editeurs);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });

                //Add event on buttons
                final Button btnReinitialiser = (Button) findViewById(R.id.btnReinitialiserEditor);
                //   btnReinitialiser.setTypeface(custom_font);
                btnReinitialiser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        api.getAllEditor(new Callback<ArrayList<Editeur>>() {
                            @Override
                            public void success(ArrayList<Editeur> Editeur, Response response) {
                                ListEditorAdaptator mAdapter = new ListEditorAdaptator(Editeur);
                                recyclerView.setAdapter(mAdapter);
                                recyclerView.setItemAnimator(new DefaultItemAnimator());
                            }

                            @Override
                            public void failure(RetrofitError error) {

                            }
                        });
                    }
                });


                final Button btnFindUser = (Button) findViewById(R.id.btnRechercherEditor);
                //     btnFindUser.setTypeface(custom_font);
                btnFindUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        final List<Editeur> Editeurs = new ArrayList<Editeur>();
                        //   if(((EditText) findViewById(R.id.tbNomJeu)).getText().toString()!= "" && ((EditText) findViewById(R.id.tbUserName)).getText().toString()!= null)
                        api.getEditorByName(((EditText) findViewById(R.id.tbRechercheEditor)).getText().toString(), new Callback<Editeur>() {
                            @Override
                            public void success(Editeur Editeur, Response response) {

                                Editeurs.add(Editeur);
                                ListEditorAdaptator mAdapter = new ListEditorAdaptator(Editeurs);
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

                final Button btnCreateUser = (Button) findViewById(R.id.btnCreateEditor);
                //       btnCreateUser.setTypeface(custom_font);
                btnCreateUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Context context = v.getContext();
                            Intent intentUtilisateurs = new Intent(v.getContext(), CreateEditor.class);
                            context.startActivity(intentUtilisateurs);
                        } catch (Exception e) {
                            e.toString();
                        }
                    }
                });
            }
        catch (Exception e){}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_liste__editor, menu);
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

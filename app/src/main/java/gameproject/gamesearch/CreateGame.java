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
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import gameproject.gamesearch.recyclerview.ListCheckEditorAdaptator;
import gameproject.gamesearch.recyclerview.ListCheckKindAdaptator;
import gameproject.gamesearch.recyclerview.ListEditorAdaptator;
import gameproject.gamesearch.recyclerview.ListKindAdaptator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class CreateGame extends ActionBarActivity {
    private ListView list;
    private int[] listCheck = new int[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);
        Create request = new Create();

        final CRUD api = request.getApiService();

        final List<Genre> allGenres = new ArrayList<Genre>();
        final List<Genre> genreCheck = new ArrayList<Genre>();
        final List<Editeur> allEditeur = new ArrayList<Editeur>();
        final List<Editeur> editeurCheck = new ArrayList<Editeur>();


        try {
            api.getAllEditor(new Callback<ArrayList<Editeur>>() {
                @Override
                public void success(ArrayList<Editeur> editeurs, Response response) {
                }

                @Override
                public void failure(RetrofitError error) {

                }

            });


            final Button btnCreate = (Button) findViewById(R.id.btnCreerCreateGame);
            //       btnCreateUser.setTypeface(custom_font);
            btnCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {

                        Jeu creerJeu = new Jeu(-1,((EditText) findViewById(R.id.tbNomJeuCreateGame)).getText().toString(),constructDateFromDatePicker((DatePicker) findViewById(R.id.dtpGameCreateGame)),((EditText) findViewById(R.id.tbDescriptifJeuCreateGame)).getText().toString(),"",editeurCheck,genreCheck,0);
                        api.createGame(creerJeu, new Callback<Jeu>() {
                            @Override
                            public void success(Jeu jeu, Response response) {

                            }

                            @Override
                            public void failure(RetrofitError error) {

                            }
                        });
                    } catch (Exception e) {
                        e.toString();
                    }
                }
            });
        }
        catch (Exception e) {
        }
    }

    public Context getBaseContext() {
        return this;
    }
    public String constructDateFromDatePicker(DatePicker dtp)
    {
        String dateFormated = String.valueOf(dtp.getYear());
        dateFormated += "-"+ String.valueOf(dtp.getMonth());
        dateFormated += "-"+ String.valueOf(dtp.getDayOfMonth());
        return dateFormated;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_game, menu);
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
/* BACKUP CREATEGAME RECYCLERVIEW CHECKBOX
<<<<<<< Updated upstream



  final RecyclerView recyclerViewGenre = (RecyclerView) findViewById(R.id.recyclerViewGenreForCreateGame);
        recyclerViewGenre.setLayoutManager(new LinearLayoutManager(this));

=======
  final RecyclerView recyclerViewGenre = (RecyclerView) findViewById(R.id.recyclerViewGenreForCreateGame);
        recyclerViewGenre.setLayoutManager(new LinearLayoutManager(this));
>>>>>>> Stashed changes
        final RecyclerView recyclerViewEditeur = (RecyclerView) findViewById(R.id.recyclerViewEditeurForGameInformation);
        recyclerViewEditeur.setLayoutManager(new LinearLayoutManager(this));
                      genreCheck.clear();
                        editeurCheck.clear();
                        Iterator<Genre> genreIterator = allGenres.iterator();
                        Iterator<Editeur> editeurIterator = allEditeur.iterator();
                        int i =0;
                        int j = 0;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
                         while (genreIterator.hasNext()) {
                         Genre e = genreIterator.next();
                    if(true)
                  {
                      String test = ((TextView) recyclerViewGenre.getChildAt(i).findViewById(R.id.item_title)).getText().toString();
                      if(test.equals(e.getNomGenre()))
                      {
                        genreCheck.add(e);
                      }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
              }
i++;
                 }
                        while (editeurIterator.hasNext()) {
                            Editeur e = editeurIterator.next();
                            if(true)
                            {
                               // int erreur=recyclerViewEditeur.getAdapter().(j);
<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
                //            String yolo = ((View) recyclerViewEditeur.ge.findViewById(R.id.chkSelected)).getClass().toString();
                            if(true)
                            {
                                String test = ((TextView) recyclerViewEditeur.getChildAt(j).findViewById(R.id.item_title)).getText().toString();
                                if(test.equals(e.getNom()))
                                {
                                    editeurCheck.add(e);
                                }
                            }
<<<<<<< Updated upstream

                        }
                            j++;
                        }

=======
                        }
                            j++;
                        }
>>>>>>> Stashed changes
                    ListEditorAdaptator mAdapterEditeur = new ListEditorAdaptator(editeurs);
                    recyclerViewEditeur.setAdapter(mAdapterEditeur);
                    recyclerViewEditeur.setItemAnimator(new DefaultItemAnimator());
                    allEditeur.addAll(editeurs);
 */
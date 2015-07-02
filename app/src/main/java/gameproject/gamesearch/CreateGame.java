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



        list =  (ListView)findViewById(R.id.listView);

        // Creation de la ArrayList qui nous permettra de remplir la listView
        final ArrayList<HashMap<String, String>> listItemEditeur = new ArrayList<HashMap<String, String>>();


        //Utilisation de notre adaptateur qui se chargera de placer les valeurs de notre liste automatiquement et d'affecter un tag a nos checkbox





        final CRUD api = request.getApiService();
        final RecyclerView recyclerViewGenre = (RecyclerView) findViewById(R.id.recyclerViewGenreForCreateGame);
        recyclerViewGenre.setLayoutManager(new LinearLayoutManager(this));

        final RecyclerView recyclerViewEditeur = (RecyclerView) findViewById(R.id.recyclerViewEditeurForGameInformation);
        recyclerViewEditeur.setLayoutManager(new LinearLayoutManager(this));
        final List<Genre> allGenres = new ArrayList<Genre>();
        final List<Genre> genreCheck = new ArrayList<Genre>();
        final List<Editeur> allEditeur = new ArrayList<Editeur>();
        final List<Editeur> editeurCheck = new ArrayList<Editeur>();


        try {
            api.getAllEditor(new Callback<ArrayList<Editeur>>() {
                @Override
                public void success(ArrayList<Editeur> editeurs, Response response) {
                    ListCheckEditorAdaptator mAdapterEditeur = new ListCheckEditorAdaptator(editeurs);
                    recyclerViewEditeur.setAdapter(mAdapterEditeur);
                    recyclerViewEditeur.setItemAnimator(new DefaultItemAnimator());
                    allEditeur.addAll(editeurs);
                }

                @Override
                public void failure(RetrofitError error) {

                }

            });
            api.getAllKind(new Callback<ArrayList<Genre>>() {



                @Override
                public void success(ArrayList<Genre> genres, Response response) {
                    // On déclare la HashMap qui contiendra les informations pour un item
              HashMap map;


              Iterator<Genre> genreIterator = genres.iterator();
              while(genreIterator.hasNext()) {
                  map = new HashMap<String, String>();
                  Genre e = genreIterator.next();
                  map.put("nom", e.getNomGenre());
                  map.put("prenom", e.getNomGenre());
                  listItemEditeur.add(map);

              }
                    MyListAdapter mSchedule = new MyListAdapter( getBaseContext(), listItemEditeur,
                       R.layout.liste_detail, new String[] { "nom","prenom" }, new int[] {
                       R.id.nom, R.id.prenom });

               // On attribue à notre listView l'adaptateur que l'on vient de créer
               list.setAdapter(mSchedule);


                }

                @Override
                public void failure(RetrofitError error) {

                }
            });

            final Button btnCreateUser = (Button) findViewById(R.id.btnCreerCreateGame);
            //       btnCreateUser.setTypeface(custom_font);
            btnCreateUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        genreCheck.clear();
                        editeurCheck.clear();
                        Iterator<Genre> genreIterator = allGenres.iterator();
                        Iterator<Editeur> editeurIterator = allEditeur.iterator();
                        int i =0;
                        int j = 0;

                         while (genreIterator.hasNext()) {
                         Genre e = genreIterator.next();
                    if(true)
                  {
                      String test = ((TextView) recyclerViewGenre.getChildAt(i).findViewById(R.id.item_title)).getText().toString();
                      if(test.equals(e.getNomGenre()))
                      {
                        genreCheck.add(e);
                      }

              }
i++;
                 }
                        while (editeurIterator.hasNext()) {
                            Editeur e = editeurIterator.next();
                            if(true)
                            {
                               // int erreur=recyclerViewEditeur.getAdapter().(j);


                //            String yolo = ((View) recyclerViewEditeur.ge.findViewById(R.id.chkSelected)).getClass().toString();
                            if(true)
                            {
                                String test = ((TextView) recyclerViewEditeur.getChildAt(j).findViewById(R.id.item_title)).getText().toString();
                                if(test.equals(e.getNom()))
                                {
                                    editeurCheck.add(e);
                                }
                            }

                        }
                            j++;
                        }
                        Jeu creerJeu = new Jeu(-1,((EditText) findViewById(R.id.tbNomJeuCreateGame)).getText().toString(),((CalendarView) findViewById(R.id.dtpDate)).getContext().toString(),((EditText) findViewById(R.id.tbDescriptifJeuCreateGame)).getText().toString(),"",editeurCheck,genreCheck,0);
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

    public void MyHandler(View v) {
        CheckBox cb = (CheckBox) v;
        //on récupère la position à l'aide du tag défini dans la classe MyListAdapter
        int position = Integer.parseInt(cb.getTag().toString());
        int posExistante =0;
        int transitionValue = 0;
        for (int i =0; i<listCheck.length;i++)
        {
            if(listCheck[i]==position)
            {
                transitionValue = i;
                listCheck[i] =-1;
            }
        }
        if(transitionValue ==0)
        {
            listCheck[position]=position;
        }


        // On récupère l'élément sur lequel on va changer la couleur
        View o = list.getChildAt(position).findViewById(
                R.id.blocCheck);

    }
    public Context getBaseContext() {
        return this;
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

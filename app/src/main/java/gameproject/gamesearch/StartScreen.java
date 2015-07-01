package gameproject.gamesearch;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StartScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        Create request = new Create();
        final CRUD api=   request.getApiService();
        Utilisateur unUtilisateur = new Utilisateur(999,"testUpdated","testUpdated");
    //    api.getAllGames(new Callback<ArrayList<Jeu>>() {
    //        @Override
    //        public void success(ArrayList<Jeu> jeus, Response response) {
    //            jeus.size();
    //        }
//
    //        @Override
    //        public void failure(RetrofitError error) {
//
    //        }
    //    });

        //GET YOUR USERS HERE !!!!!!
   //  List<Utilisateur> lesUtilisateurs =  CrudUtilisateur.getAllUser();
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        String T="";



        TextView titre = (TextView)findViewById(R.id.titre);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/arcade.ttf");
        titre.setTypeface(custom_font);

        final Button liste_jeux = (Button) findViewById(R.id.button_jeux);
        liste_jeux.setTypeface(custom_font);
        liste_jeux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentJeux = new Intent(StartScreen.this, Liste_jeux.class);
                startActivity(intentJeux);
            }
        });

        final Button liste_utilisateurs = (Button) findViewById(R.id.button_utilisateurs);
        liste_utilisateurs.setTypeface(custom_font);
        liste_utilisateurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUtilisateurs = new Intent(StartScreen.this, Liste_utilisateurs.class);
                startActivity(intentUtilisateurs);
            }
        });

        final Button listeEditeur = (Button) findViewById(R.id.btnEditeur);
        listeEditeur.setTypeface(custom_font);
        listeEditeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUtilisateurs = new Intent(StartScreen.this, Liste_Editor.class);
                startActivity(intentUtilisateurs);
            }
        });

        final Button listeGenre = (Button) findViewById(R.id.btnGenre);
        listeGenre.setTypeface(custom_font);
        listeGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUtilisateurs = new Intent(StartScreen.this, List_Genre.class);
                startActivity(intentUtilisateurs);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_screen, menu);
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

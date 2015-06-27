package gameproject.gamesearch;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class PrimaryActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primary_activity);

        List<Editeur> testEditeur = new ArrayList<Editeur>();
        List<Genre> testGenre = new ArrayList<Genre>();
        Norme testNorme =new Norme();

        Create request = new Create();
        final ApiService api=   request.getApiService();


        Date d = new Date();
        Jeu unjeuTest = new Jeu(100,"test", d,"test","test", testEditeur,testGenre, testNorme);
        Utilisateur unUtilisateur = new Utilisateur(999,"test","test");
        Gson gson = new Gson();

        String json=  gson.toJson(unUtilisateur);
       // ApiService client = (ApiService) ServiceGenerator.createService(Utilisateur.class,"http://localhost:3229");
        api.createUtilisateur(unUtilisateur, new Callback<String>() {
            @Override
            public void success(String s, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


//Create request = new Create();
           //api.getContent(new Callback<Jeu>() {
           //    @Override
           //    public void success(Jeu jeu, Response response) {
           //        jeu.getNomJeu();


           //    }

           //    @Override
           //    public void failure(RetrofitError error) {
           //        Log.i("JESUISLERREUR                ",error.getMessage());
           //    }
           //});
           //String a = "";

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_primary, menu);
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

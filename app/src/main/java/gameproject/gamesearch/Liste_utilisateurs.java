package gameproject.gamesearch;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.squareup.okhttp.internal.Util;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import gameproject.gamesearch.recyclerview.ItemData;
import gameproject.gamesearch.recyclerview.MyAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class Liste_utilisateurs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_utilisateurs);
        Create request = new Create();
        final CRUD api=   request.getApiService();


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
           api.getAllUser(new Callback<ArrayList<Utilisateur>>() {
               @Override
               public void success(ArrayList<Utilisateur> utilisateurs, Response response) {
                   MyAdapter mAdapter = new MyAdapter(utilisateurs);
                   recyclerView.setAdapter(mAdapter);
                   recyclerView.setItemAnimator(new DefaultItemAnimator());
               }

               @Override
               public void failure(RetrofitError error) {

               }
           });

        }
        catch (Exception e)
        {
            e.toString();
        }

        //allUser.add(new Utilisateur(1,"1","1"));
        //allUser.add(new Utilisateur(1,"2","2"));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_liste_utilisateurs, menu);
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

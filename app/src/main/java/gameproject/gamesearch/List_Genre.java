package gameproject.gamesearch;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import gameproject.gamesearch.recyclerview.ListEditorAdaptator;
import gameproject.gamesearch.recyclerview.ListKingAdaptator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class List_Genre extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__genre);


        Create request = new Create();
        final CRUD api=   request.getApiService();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGenre);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {

            api.getAllKind(new Callback<ArrayList<Genre>>() {
                @Override
                public void success(ArrayList<Genre> genres, Response response) {
                    ListKingAdaptator mAdapter = new ListKingAdaptator(genres);
                    recyclerView.setAdapter(mAdapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });

        }
        catch (Exception e){}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list__genre, menu);
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

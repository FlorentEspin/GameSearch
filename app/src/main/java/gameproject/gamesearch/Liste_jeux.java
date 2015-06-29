package gameproject.gamesearch;

import android.app.Activity;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;



public class Liste_jeux extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_jeux);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);



    //   recyclerView.setLayoutManager(new LinearLayoutManager(this));

    //   MyAdapter mAdapter = new MyAdapter(itemsData);
    //   recyclerView.setAdapter(mAdapter);
    //   recyclerView.setItemAnimator(new DefaultItemAnimator());



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_liste_jeux, menu);
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

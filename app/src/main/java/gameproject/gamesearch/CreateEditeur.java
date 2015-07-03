package gameproject.gamesearch;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class CreateEditeur extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_editeur);

        Create request = new Create();
        final CRUD api=   request.getApiService();
        final Button btnCreate = (Button) findViewById(R.id.btnCreerCreateEditeur);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Editeur editeur = new Editeur(-1, ((EditText) findViewById(R.id.tbEditorNameCreateEditor)).getText().toString());

                api.createEditor(editeur, new Callback<Editeur>() {
                    @Override
                    public void success(Editeur editeur, Response response) {
                        Intent intentGenre = new Intent(v.getContext(), Liste_Editor.class);
                        startActivity(intentGenre);
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });


            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_editeur, menu);
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

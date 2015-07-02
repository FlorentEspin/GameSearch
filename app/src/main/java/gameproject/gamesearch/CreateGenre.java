    package gameproject.gamesearch;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


    public class CreateGenre extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_genre);

        Create request = new Create();
        final CRUD api=   request.getApiService();
        final Button btnCreate = (Button) findViewById(R.id.btnCreerCreateGenre);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Genre genre = new Genre(-1, ((EditText) findViewById(R.id.tbNomGenreCreateGenre)).getText().toString());

                api.createKind(genre, new Callback<Genre>() {
                    @Override
                    public void success(Genre nediteur, Response response) {
                        CharSequence text = "Genre cree !";
                        int duration = Toast.LENGTH_SHORT;

                        Toast valitoast = Toast.makeText(getApplicationContext(),text,duration);
                        valitoast.show();

                        Intent intentGenre = new Intent(CreateGenre.this, List_Genre.class);
                        startActivity(intentGenre);

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        CharSequence text = "Creation impossible !";
                        int duration = Toast.LENGTH_SHORT;

                        Toast valitoast = Toast.makeText(getApplicationContext(),text,duration);
                        valitoast.show();
                    }
                });

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_genre, menu);
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

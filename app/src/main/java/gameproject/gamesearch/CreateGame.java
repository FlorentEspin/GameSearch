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


public class CreateGame extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        Create request = new Create();
        final CRUD api=   request.getApiService();
        final Button btnCreateUser = (Button) findViewById(R.id.btnValidateCreate);
        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilisateur createUser = new Utilisateur(-1,((EditText) findViewById(R.id.tbLoginCreate)).getText().toString(),((EditText) findViewById(R.id.tbLPasswordCreate)).getText().toString());

                api.createUtilisateur(createUser, new Callback<Utilisateur>() {
                    @Override
                    public void success(Utilisateur utilisateur, Response response) {

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

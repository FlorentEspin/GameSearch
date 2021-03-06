package gameproject.gamesearch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class CreateUser extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        final Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/arcade.ttf");


        TextView loginLabel = (TextView) findViewById(R.id.lblLoginCreate);
        loginLabel.setTypeface(custom_font);

        TextView passwordLabel = (TextView) findViewById(R.id.lblPasswordCreate);
        passwordLabel.setTypeface(custom_font);

        Create request = new Create();
        final CRUD api=   request.getApiService();
        final Button btnCreateUser = (Button) findViewById(R.id.btnValidateCreate);
        btnCreateUser.setTypeface(custom_font);
        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilisateur createUser = new Utilisateur(-1,((EditText) findViewById(R.id.tbLoginCreate)).getText().toString(),((EditText) findViewById(R.id.tbLPasswordCreate)).getText().toString());

                api.createUtilisateur(createUser, new Callback<Utilisateur>() {
                    @Override
                    public void success(Utilisateur utilisateur, Response response) {
                        CharSequence text = "Utilisateur cree !";
                        int duration = Toast.LENGTH_SHORT;

                        Toast valitoast = Toast.makeText(getApplicationContext(),text,duration);
                        valitoast.show();

                        Intent intentUtilisateurs = new Intent(CreateUser.this, Liste_utilisateurs.class);
                        startActivity(intentUtilisateurs);
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

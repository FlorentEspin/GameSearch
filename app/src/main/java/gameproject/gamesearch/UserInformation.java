package gameproject.gamesearch;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class UserInformation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        final Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/arcade.ttf");

        Create request = new Create();
        final CRUD api=   request.getApiService();

        String ID ="";
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            ID = getIntent().getStringExtra("ID");
            try {
                api.getUserById(Integer.parseInt(ID), new Callback<Utilisateur>() {
                    @Override
                    public void success(Utilisateur utilisateur, Response response) {
                        //ADD ID
                        TextView tbID = (TextView) findViewById(R.id.tbUserID);
                        tbID.setText(String.valueOf(utilisateur.getID_UTILISATEUR()));
                        TextView idUser = (TextView) findViewById(R.id.lblUserID);
                        tbID.setTypeface(custom_font);
                        idUser.setTypeface(custom_font);

                        //ADD LOGIN
                        EditText tbLogin = (EditText) findViewById(R.id.tbLogin);
                        tbLogin.setText(utilisateur.getLOGIN());

                        tbLogin.setTypeface(custom_font);
                        //ADD PASSWORD
                        EditText  tbPassword = (EditText) findViewById(R.id.tbPassword);
                        tbPassword.setText(utilisateur.getPASSWORD());
                        tbPassword.setTypeface(custom_font);
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
            catch(Exception e)
            {

            }
        }
        final String userID = getIntent().getStringExtra("ID");
        final Button btnModify = (Button) findViewById(R.id.btnKindModify);
        btnModify.setTypeface(custom_font);
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilisateur modifiedUser = new Utilisateur(Integer.parseInt(userID),((EditText) findViewById(R.id.tbLogin)).getText().toString(),((EditText) findViewById(R.id.tbPassword)).getText().toString());
                api.updateUser(modifiedUser, new Callback<Utilisateur>() {
                    @Override
                    public void success(Utilisateur utilisateur, Response response) {

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });

            }
        });
        final Button btnDelete = (Button) findViewById(R.id.btnDeleteJeu);
        btnDelete.setTypeface(custom_font);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                api.deleteUser(Integer.parseInt(userID), new Callback<String>() {
                    @Override
                    public void success(String s, Response response) {

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
        getMenuInflater().inflate(R.menu.menu_game_information, menu);
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

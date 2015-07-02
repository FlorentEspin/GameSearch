package gameproject.gamesearch;

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


public class KindInformation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind_information);

        Create request = new Create();
        final CRUD api=   request.getApiService();

        String ID ="";
        Bundle extras = getIntent().getExtras();



        if (extras != null) {
            ID = getIntent().getStringExtra("ID");
            try {
                api.getKindById(Integer.parseInt(ID), new Callback<Genre>() {
                    @Override
                    public void success(Genre Genre, Response response) {

                        //ADD ID
                        TextView tbID = (TextView) findViewById(R.id.tbKindIDKindInformation);
                        tbID.setText(String.valueOf(Genre.getIdGenre()));
                        //ADD NAME
                        EditText tbLogin = (EditText) findViewById(R.id.tbKindNameKindInformation);
                        tbLogin.setText(Genre.getNomGenre());
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
        final Button btnModify = (Button) findViewById(R.id.btnKindModifyKindInformation);
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Genre modifiedUser = new Genre(Integer.parseInt(userID), ((EditText) findViewById(R.id.tbKindNameKindInformation)).getText().toString());
                api.updateKind(modifiedUser, new Callback<Genre>() {
                    @Override
                    public void success(Genre Genre, Response response) {

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });

            }
        });
        final Button btnDelete = (Button) findViewById(R.id.btnDeleteKindKindInformation);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userID != "" && userID != null) {
                    api.deleteEditor(Integer.parseInt(userID), new Callback<String>() {
                        @Override
                        public void success(String s, Response response) {

                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kind_information, menu);
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

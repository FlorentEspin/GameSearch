package gameproject.gamesearch;

import android.util.Log;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Nox on 27/06/2015.
 */
public class CrudUtilisateur {

    Create request = new Create();
    final ApiService api=   request.getApiService();

    public Utilisateur getUserById(int id)
    {

    }

    public void createUser(Utilisateur aUser)
    {
        try
        {
            api.createUtilisateur(aUser, new Callback<String>() {
                @Override
                public void success(String s, Response response) {
                   
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
}

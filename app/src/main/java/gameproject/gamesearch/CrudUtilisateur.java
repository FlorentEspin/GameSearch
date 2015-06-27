package gameproject.gamesearch;

import android.util.Log;

import com.squareup.okhttp.internal.Util;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Nox on 27/06/2015.
 */
public class CrudUtilisateur {

    private static Create request = new Create();
    private static ApiService api =  request.getApiService();
  //  public Utilisateur getUserById(int id)
  //  {
//
  //  }
//
    public static List<Utilisateur> getAllUser()
    {
       final List<Utilisateur> users = new ArrayList<Utilisateur>();
        api.getAllUser(new Callback<ArrayList<Utilisateur>>() {
            @Override
            public void success(ArrayList<Utilisateur> utilisateurs, Response response) {
                users.addAll((ArrayList<Utilisateur>) utilisateurs);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return users;
    }

    public void createUser(final Utilisateur aUser)
    {
        try
        {
            api.createUtilisateur(aUser, new Callback<String>() {
                @Override
                public void success(String s, Response response) {
                    Log.i("SUCESS, ADDING USER : ",aUser.getLOGIN());
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.i("ERROR ENCOUNTER IN CREATEUSER : ",error.getMessage());
                }
            });
        }
        catch(Exception e)
        {
            Log.i("ERROR ENCOUNTER IN CREATEUSER, BEFORE CONNECTING TO THE WEB SERVICE. ",e.getMessage());
        }
    }
}

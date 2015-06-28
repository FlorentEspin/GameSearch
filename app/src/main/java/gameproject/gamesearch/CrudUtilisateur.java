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
      final   ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
        api.getAllUser(new Callback<ArrayList<Utilisateur>>() {
            @Override
            public void success(ArrayList<Utilisateur> utilisateurs, Response response) {
               System.arraycopy(utilisateurs,0,users,0,utilisateurs.size());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return users;
    }


        public void updateUser(Utilisateur aUser)
        {

        }
}

package gameproject.gamesearch;

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
    private static CRUD api =  request.getApiService();
  //  public Utilisateur getUserById(int id)
  //  {
//
  //  }
//
    public static List<Utilisateur> getAllUser()
    {
      final   ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();

        return users;
    }


        public void updateUser(Utilisateur aUser)
        {

        }
}

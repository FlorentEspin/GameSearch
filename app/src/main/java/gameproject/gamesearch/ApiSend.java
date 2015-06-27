package gameproject.gamesearch;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Nox on 26/05/2015.
 */
public interface ApiSend {
    @POST("/api/Utilisateurs")
    void createUser(@Body Utilisateur user, Callback<Utilisateur> cb);
}
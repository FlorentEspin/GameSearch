package gameproject.gamesearch;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Nox on 15/05/2015.
 */
public interface ApiService {

    @GET("/api/jeux")
    public void getContent(Callback<Jeu> callback);

    @POST("/api/jeux")
    public void createTask(@Body Jeu unJeu, Callback<Jeu> cb);

    @POST("/api/Utilisateurs")
    public void createUtilisateur(@Body Utilisateur unUtilisateur, Callback<String> cb);

}

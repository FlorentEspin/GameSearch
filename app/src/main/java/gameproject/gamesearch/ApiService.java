package gameproject.gamesearch;

import android.database.Observable;

import com.google.gson.Gson;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Nox on 15/05/2015.
 */
public interface ApiService {

    @GET("/api/Jeux")
    public void getAllGames(Callback<ArrayList<Jeu>> cb);

    @POST("/api/jeux")
    public void createTask(@Body Jeu unJeu, Callback<Jeu> cb);

    @GET("/api/Utilisateurs")
    public List<Utilisateur> getAllUser(Callback<ArrayList<Utilisateur>> cb);

    @GET("/api/Utilisateurs")
    public void getUserById(@Body int userID, Callback<String> cb);

    @POST("/api/Utilisateurs")
    public void createUtilisateur(@Body Utilisateur unUtilisateur, Callback<Utilisateur> cb);
    @PUT("/api/Utilisateurs")
    Utilisateur updateUser(Utilisateur aUSer,Callback<String> cb);


}

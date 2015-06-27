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
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Nox on 15/05/2015.
 */
public interface ApiService {

    @GET("/api/jeux")
    public void getContent(Callback<List<Utilisateur>> callback);

    @POST("/api/jeux")
    public void createTask(@Body Jeu unJeu, Callback<Jeu> cb);

    @POST("/api/Utilisateurs")
    public void createUtilisateur(@Body Utilisateur unUtilisateur, Callback<String> cb);

    @GET("/api/Utilisateurs")
    void getAllUser(Callback<List<Utilisateur>> cb);

    @GET("/api/Utilisateurs")
    public void     getUserById(@Body int userID, Callback<String> cb);



}

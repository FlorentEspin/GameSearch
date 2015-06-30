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
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Nox on 15/05/2015.
 */
public interface CRUD {
//region CRUD FOR GAMES
    @GET("/api/Jeux")
    public void getAllGames(Callback<ArrayList<Jeu>> cb);
    @GET("/api/Jeux")
    public void getGameById(@Query("id")int gameID, Callback<Jeu> cb);
    @GET("/api/Jeux")
    public void getGameByName(@Query("name")String gameName, Callback<Jeu> cb);
    @POST("/api/jeux")
    public void createGame(@Body Jeu unJeu, Callback<Jeu> cb);
    @POST("/api/jeux")
    public void UpdateGame(@Body Jeu unJeu, Callback<Jeu> cb);
    @POST("/api/jeux")
    public void deleteGame(@Query("ID")int gameID, Callback<String> cb);
//endregion
//region CRUD FOR USERS

    @GET("/api/Utilisateurs")
    public void getAllUser(Callback<ArrayList<Utilisateur>> cb);
    @GET("/api/Utilisateurs")
    public void getUserById(@Query("id")int userID, Callback<Utilisateur> cb);
    @GET("/api/Utilisateurs")
    public void getUserByName(@Query("name")String gameName, Callback<Utilisateur> cb);
    @POST("/api/Utilisateurs")
    public void createUtilisateur(@Body Utilisateur aUser, Callback<Utilisateur> cb);
    @POST("/api/Utilisateurs")
    public void updateUser(@Body Utilisateur aUser, Callback<Utilisateur> cb);
    @DELETE("/api/Utilisateurs")
    public void deleteUser(@Query("ID")int userID, Callback<String> cb);
    //endregion
//region CRUD FOR EDITORS

    @GET("/api/Editeurs")
    public void getAllEditor(Callback<ArrayList<Editeur>> cb);
    @GET("/api/Editeurs")
    public void getEditorById(@Query("id")int editorID, Callback<Editeur> cb);
    @GET("/api/Editeurs")
    public void getEditorByName(@Query("name")String editorName, Callback<Editeur> cb);
    @POST("/api/Editeurs")
    public void createEditor(@Body Editeur aEditor, Callback<Editeur> cb);
    @POST("/api/Editeurs")
    public void updateEditor(@Body Editeur aEditor, Callback<Editeur> cb);
    @DELETE("/api/Editeurs")
    public void deleteEditor(@Query("ID")int editorID, Callback<String> cb);
    //endregion

//region CRUD FOR KINDS

    @GET("/api/Genres")
    public void getAllKind(Callback<ArrayList<Genre>> cb);
    @GET("/api/Genres")
    public void getKindById(@Query("id")int kindID, Callback<Genre> cb);
    @GET("/api/Genres")
    public void getKindByName(@Query("name")String kindName, Callback<Genre> cb);
    @POST("/api/Genres")
    public void createKind(@Body Genre aKind, Callback<Genre> cb);
    @POST("/api/Genres")
    public void updateKind(@Body Genre aKind, Callback<Genre> cb);
    //endregion
}

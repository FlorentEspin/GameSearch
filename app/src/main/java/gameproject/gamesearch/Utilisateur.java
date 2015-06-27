package gameproject.gamesearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Utilisateur {
    @SerializedName("$id")
    @Expose
    private int ID;
    @SerializedName("$values")
    @Expose
    private List<Utilisateur> value;
    @SerializedName("ID_UTILISATEUR")
    @Expose
    private int ID_UTILISATEUR;
    @SerializedName("LOGIN")
    @Expose
    private String LOGIN;
    @SerializedName("PASSWORD")
    @Expose
    private String PASSWORD;

    public Utilisateur(int idutilisateur, String loginUtilisateur, String passwordUtilisateur) {
        this.ID_UTILISATEUR = idutilisateur;
        this.LOGIN = loginUtilisateur;
        this.PASSWORD = passwordUtilisateur;
    }

    public int getID_UTILISATEUR() {
        return ID_UTILISATEUR;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setID_UTILISATEUR(int ID_UTILISATEUR) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
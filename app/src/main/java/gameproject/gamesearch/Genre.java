package gameproject.gamesearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genre {
    @SerializedName("ID_GENRE")
    @Expose
    private int idGenre;
    @SerializedName("NOM_GENRE")
    @Expose
    private String nomGenre;
    
    public Genre(){}
    public Genre(int idGenre, String nomGenre) {
        this.idGenre = idGenre;
        this.nomGenre = nomGenre;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public void setNomGenre(String nomGenre) {
        this.nomGenre = nomGenre;
    }   
}
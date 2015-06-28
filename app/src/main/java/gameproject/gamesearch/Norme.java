package gameproject.gamesearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Norme {
    @SerializedName("ID_NORME")
    @Expose
    private int idNorme;
    @SerializedName("DESCRIPTION")
    @Expose
    private String descriptionNorme;
    
    public Norme(){}

    public Norme(int idNorme, String descriptionNorme) {
        this.idNorme = idNorme;
        this.descriptionNorme = descriptionNorme;
    }

    public int getIdNorme() {
        return idNorme;
    }

    public String getDescriptionNorme() {
        return descriptionNorme;
    }

    public void setIdNorme(int idNorme) {
        this.idNorme = idNorme;
    }

    public void setDescriptionNorme(String descriptionNorme) {
        this.descriptionNorme = descriptionNorme;
    }
}
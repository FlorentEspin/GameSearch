/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.gamesearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Editeur {
    @SerializedName("ID_EDITEUR")
    @Expose
    private int id;
    @SerializedName("NOM_EDITEUR")
    @Expose
    private String nom;
    public Editeur(){}
    public Editeur (int IdEditeur, String NomEditeur)
    {
        id=IdEditeur;
        nom=NomEditeur;    
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}

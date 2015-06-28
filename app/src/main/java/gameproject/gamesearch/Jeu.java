package gameproject.gamesearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Jeu {
    @SerializedName("ID_JEU")
    @Expose
    private int idJeu=0;
    @SerializedName("NOM_JEU")
    @Expose
    private String nomJeu="";
    @SerializedName("DATE_DE_SORTIE")
    @Expose
    private String dateDeSortieJeu= "";
    @SerializedName("DESCRIPTIF")
    @Expose
    private String descriptifJeu="";
    @SerializedName("IMAGE")
    @Expose
    private String imageJeu ="";
    @SerializedName("EDITEURs")
    @Expose
    public List<Editeur> Editeur = new ArrayList<Editeur>();
    @SerializedName("GENREs")
    @Expose
    public List<Genre> Genre= new ArrayList<Genre>();
    @SerializedName("ID_NORME")
    @Expose
    private int normeJeu = 0;

    public Jeu() {
    }

    public Jeu(int idJeu, String nomJeu, String dateDeSortieJeu, String descriptifJeu, String imageJeu, List<Editeur> Editeur, List<Genre> Genre, int normeJeu) {
        this.idJeu = idJeu;
        this.nomJeu = nomJeu;
        this.dateDeSortieJeu = dateDeSortieJeu;
        this.descriptifJeu = descriptifJeu;
        this.imageJeu = imageJeu;
        this.Editeur = Editeur;
        this.Genre = Genre;
        this.normeJeu = normeJeu;
    }

    public int getIdJeu() {
        return idJeu;
    }

    public String getNomJeu() {
        return nomJeu;
    }

    public String getDateDeSortieJeu() {
        return dateDeSortieJeu;
    }

    public String getDescriptifJeu() {
        return descriptifJeu;
    }

    public String getImageJeu() {
        return imageJeu;
    }

    public List<Editeur> getEditeur() {
        return Editeur;
    }

    public List<Genre> getGenre() {
        return Genre;
    }

    public int getNormeJeu() {
        return normeJeu;
    }

    public void setIdJeu(int idJeu) {
        this.idJeu = idJeu;
    }

    public void setNomJeu(String nomJeu) {
        this.nomJeu = nomJeu;
    }

    public void setDateDeSortieJeu(String dateDeSortieJeu) {
        this.dateDeSortieJeu = dateDeSortieJeu;
    }

    public void setDescriptifJeu(String descriptifJeu) {
        this.descriptifJeu = descriptifJeu;
    }

    public void setImageJeu(String imageJeu) {
        this.imageJeu = imageJeu;
    }

    public void setEditeur(List<Editeur> Editeur) {
        this.Editeur = Editeur;
    }

    public void setGenre(List<Genre> Genre) {
        this.Genre = Genre;
    }

    public void setNormeJeu(int normeJeu) {
        this.normeJeu = normeJeu;
    }   
}
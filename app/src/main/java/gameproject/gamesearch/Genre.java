package gameproject.gamesearch;

public class Genre {
    private int idGenre;
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
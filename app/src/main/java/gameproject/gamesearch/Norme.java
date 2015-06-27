package gameproject.gamesearch;

public class Norme {
    
    private int idNorme;
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
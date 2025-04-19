package tn.essat.miniprojetmjaiedwael;

public class Matiere {
    private int id;
    private String titre;
    private String niveau;

    public Matiere(int id, String titre, String niveau) {
        this.id = id;
        this.titre = titre;
        this.niveau = niveau;
    }

    public Matiere() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}

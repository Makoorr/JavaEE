package tn.insat.tp1.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Enseignant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nomEns")
    private String nom;
    
    @Column(name = "prenomEns")
    private String prenom;

    @Column(name = "dateEns")
    private String dateEns;

    @ManyToMany(mappedBy = "enseignants")
    private Departement departement;

    public Enseignant() {
    	System.out.println("Add parametres!");
    }

    public Enseignant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
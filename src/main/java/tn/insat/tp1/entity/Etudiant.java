package tn.insat.tp1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nomEt")
    private String nom;
    
    @Column(name = "prenomEt")
    private String prenom;
    
    @Column(name = "dateEt")
    private Date datef;

    @ManyToOne
    private Departement departement;

    public Etudiant(int id, String nom, String prenom, Date datef) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datef = datef;
    }
    
    public Etudiant() {
    	System.out.println("Add parametres!");
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

    public Date getDatef() {
        return datef;
    }

    public void setDatef(Date datef) {
        this.datef = datef;
    }
    
    public Departement getDepartement() {
        return departement;
    }

    public void setDepartementf(Departement departement) {
        this.departement = departement;
    }
}
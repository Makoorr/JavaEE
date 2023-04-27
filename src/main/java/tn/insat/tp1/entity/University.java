package tn.insat.tp1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

public class University implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nomUni")
    private String nom;
    @Column(name = "addressUni")
    private String address;

    @OneToMany(mappedBy = "university")
    private List<Departement> departements;

    public University(int id, String nom, String address) {
        this.id = id;
        this.nom = nom;
        this.address = address;
    }

    public University() {}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
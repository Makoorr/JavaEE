package tn.insat.tp1.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nomDep")
    private String nom;

    @Column(name = "specialityDep")
    private Speciality speciality;

    @ManyToMany(mappedBy = "departements")
    private Enseignant enseignant;

    @OneToMany(mappedBy = "departement")
    private List<Etudiant> etudiants;

    @ManyToOne
    private University university;

    public Departement(int id, String nom, Speciality speciality) {
        this.id = id;
        this.nom = nom;
        this.speciality = speciality;
    }

    public Departement() {
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
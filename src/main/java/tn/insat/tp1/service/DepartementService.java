package tn.insat.tp1.service;

import java.util.List;

import tn.insat.tp1.entity.Departement;

public interface DepartementService {
    
    List<Departement> retrieveAllDepartements();
    Departement addDepartement(Departement Departement);
    void deleteDepartement(Long id);
    Departement updateDepartement(Departement Departement);
    Departement retrieveDepartement(Long id);
    List<Departement> retrieveDepartementsByUniversite(Long idUniversite);
}

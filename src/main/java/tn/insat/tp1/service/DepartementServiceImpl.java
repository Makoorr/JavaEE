package tn.insat.tp1.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import tn.insat.tp1.entity.Departement;
import tn.insat.tp1.repository.DepartementRepository;

public class DepartementServiceImpl implements DepartementService{

    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return (List<Departement>) departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

    @Override
    public Departement updateDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public Departement retrieveDepartement(Long id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Long idUniversite) {
        List<Departement> ll = new ArrayList<Departement>();
        for (Departement departement : departementRepository.findAll()) {
            if (departement.getUniversity().getId() == idUniversite) {
                ll.add(departement);
            }
        }
        return ll;
    }       
}
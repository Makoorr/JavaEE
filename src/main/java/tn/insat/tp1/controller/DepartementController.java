package tn.insat.tp1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.insat.tp1.entity.Departement;
import tn.insat.tp1.service.DepartementServiceImpl;

@RestController
class DepartementController {
    @Autowired
    private DepartementServiceImpl departementService;
    
    @GetMapping("/departement")
    List<Departement> all() {
        return departementService.retrieveAllDepartements();
    }
    
    @GetMapping("/departement/{id}")
    Departement one(@PathVariable Long id) {
        return departementService.retrieveDepartement(id);
    }

    @PostMapping("/departement")
    Departement newDepartement(@RequestBody Departement newDepartement) {
        return departementService.addDepartement(newDepartement);
    }

    @PutMapping("/departement/{id}")
    Departement replaceDepartement(@PathVariable Long id, @RequestBody Departement newDepartement ) {
        Departement departement = departementService.retrieveDepartement(id);

        departement.setNom(newDepartement.getNom());
        departement.setSpeciality(newDepartement.getSpeciality());
        departement.setEnseignant(newDepartement.getEnseignant());
        departement.setUniversity(newDepartement.getUniversity());
        
        return departementService.updateDepartement(departement);
    }

    @DeleteMapping("/departement/{id}")
    void deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
    }
}

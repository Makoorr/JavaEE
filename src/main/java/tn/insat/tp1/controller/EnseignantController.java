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

import tn.insat.tp1.entity.Enseignant;
import tn.insat.tp1.service.EnseignantServiceImpl;

@RestController
class EnseignantController {
    @Autowired
    private EnseignantServiceImpl enseignantService;
    
    @GetMapping("/enseignants")
    List<Enseignant> all() {
        return enseignantService.retrieveAllEnseignants();
    }
    
    @GetMapping("/enseignants/{id}")
    Enseignant one(@PathVariable Long id) {
        return enseignantService.retrieveEnseignant(id);
    }

    @PostMapping("/enseignants")
    Enseignant newEnseignant(@RequestBody Enseignant newEnseignant) {
        return enseignantService.addEnseignant(newEnseignant);
    }

    @PutMapping("/enseignants/{id}")
    Enseignant replaceEnseignant(@PathVariable Long id, @RequestBody Enseignant newEnseignant ) {
        Enseignant enseignant = enseignantService.retrieveEnseignant(id);

        enseignant.setNom(newEnseignant.getNom());
        enseignant.setPrenom(newEnseignant.getPrenom());
        enseignant.setDepartement(newEnseignant.getDepartement());
        
        return enseignantService.updateEnseignant(enseignant);
    }

    @DeleteMapping("/enseignants/{id}")
    void deleteEnseignant(@PathVariable Long id) {
        enseignantService.deleteEnseignant(id);
    }
}
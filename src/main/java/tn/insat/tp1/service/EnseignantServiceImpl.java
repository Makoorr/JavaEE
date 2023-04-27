package tn.insat.tp1.service;

import tn.insat.tp1.entity.Enseignant;
import tn.insat.tp1.entity.Etudiant;
import tn.insat.tp1.repository.EnseignantRepository;
import tn.insat.tp1.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnseignantServiceImpl implements EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;
    
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Enseignant> retrieveAllEnseignants() {
        return (List<Enseignant>) enseignantRepository.findAll();
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant retrieveEnseignant(Long id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Enseignant> getEnseigantsByDepartement(Integer idDepartement) {
        List<Enseignant> ll = new ArrayList<Enseignant>();
        for (Enseignant enseignant : enseignantRepository.findAll()) {
            if (enseignant.getDepartement().getId() == idDepartement) {
                ll.add(enseignant);
            }
        }
        return ll;
    }

    @Override
    public List<Enseignant> retrieveEnseignantsByEtudiantsId(Integer idEtudiant) {
        List<Enseignant> ll = new ArrayList<Enseignant>();
        for (Etudiant etudiant : etudiantRepository.findAll()) {
            if (etudiant.getId() == idEtudiant) {
                ll = this.getEnseigantsByDepartement(etudiant.getDepartement().getId());
            }
        }
        return ll;
    }
}
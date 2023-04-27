package tn.insat.tp1.service;

import java.util.List;
import tn.insat.tp1.entity.Enseignant;

public interface EnseignantService {
    List<Enseignant> retrieveAllEnseignants();
    Enseignant addEnseignant(Enseignant enseignant);
    void deleteEnseignant(Long id);
    Enseignant updateEnseignant(Enseignant enseignant);
    Enseignant retrieveEnseignant(Long id);
    List<Enseignant> getEnseigantsByDepartement(Integer idDepartement);
    List<Enseignant> retrieveEnseignantsByEtudiantsId(Integer idEtudiants);
}
package tn.insat.tp1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.tp1.entity.Etudiant;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {
	
    @Query("SELECT e FROM Etudiant e WHERE e.dateEt >= '1995-01-01' AND e.dateEt <= '1996-01-01'")
    List<Etudiant> retrieveEtudiantsBetweenDates();
}
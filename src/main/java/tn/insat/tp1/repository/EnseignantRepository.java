package tn.insat.tp1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.tp1.entity.Enseignant;

@Repository
public interface EnseignantRepository extends CrudRepository<Enseignant, Long>{
    
    @Query("SELECT COUNT(e) FROM Enseignant e")
    int countEnseignant();

    @Query("SELECT e FROM Enseignant e WHERE e.dateEns >= '1980-01-01' AND e.dateEns <= '1982-01-01'")
    List<Enseignant> retrieveEnseignantsBetweenDates();
}
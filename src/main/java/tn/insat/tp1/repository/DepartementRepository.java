package tn.insat.tp1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.insat.tp1.entity.Departement;

@Repository
public interface DepartementRepository  extends CrudRepository<Departement, Long>{
    
    @Query("SELECT COUNT(d) FROM Departement d WHERE d.speciality = 'GL'")
    int countDepartementGL();
}
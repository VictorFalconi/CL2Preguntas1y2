package pe.edu.cibertec.WAEC2VictorFalconi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.PersonaModel;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaModel, Integer> {

}

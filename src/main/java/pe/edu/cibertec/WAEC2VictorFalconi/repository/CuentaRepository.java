package pe.edu.cibertec.WAEC2VictorFalconi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.CuentaModel;

public interface CuentaRepository extends JpaRepository<CuentaModel, Integer> {
}

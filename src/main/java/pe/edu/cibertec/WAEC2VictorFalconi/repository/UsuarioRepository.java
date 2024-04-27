package pe.edu.cibertec.WAEC2VictorFalconi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.UsuarioModel;

@Repository
public interface UsuarioRepository extends
        JpaRepository<UsuarioModel, Integer> {
    UsuarioModel findByEmail(String email);
    UsuarioModel findByNomusuario(String nomusuario);
}

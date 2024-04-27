package pe.edu.cibertec.WAEC2VictorFalconi.service;

import org.springframework.context.annotation.Bean;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.CuentaModel;

import java.util.List;

public interface ICuentaService {
    List<CuentaModel> listarCuentas();
    void registrarCuenta(CuentaModel cuentaModel);
}

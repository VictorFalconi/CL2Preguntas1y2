package pe.edu.cibertec.WAEC2VictorFalconi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.CuentaModel;
import pe.edu.cibertec.WAEC2VictorFalconi.repository.CuentaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CuentaService implements ICuentaService{
    private CuentaRepository cuentaRepository;
    @Override
    public List<CuentaModel> listarCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public void registrarCuenta(CuentaModel cuentaModel) {
        cuentaRepository.save(cuentaModel);
    }
}

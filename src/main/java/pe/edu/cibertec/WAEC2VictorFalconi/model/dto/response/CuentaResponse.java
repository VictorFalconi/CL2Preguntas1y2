package pe.edu.cibertec.WAEC2VictorFalconi.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CuentaResponse {
    private Boolean respuesta;
    private String mensaje;
}

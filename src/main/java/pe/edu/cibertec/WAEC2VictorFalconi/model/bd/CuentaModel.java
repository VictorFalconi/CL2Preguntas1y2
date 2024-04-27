package pe.edu.cibertec.WAEC2VictorFalconi.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="cuenta")
public class CuentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcuenta;
    @Column(name = "nrocuenta")
    private String nrocuenta;
    @Column(name = "fecharegistro")
    private Date fecharegistro;
    @Column(name = "fechavencimiento")
    private Date fechavencimiento;
    @ManyToOne
    @JoinColumn(name = "idpersona")
    private PersonaModel personaModel;
}

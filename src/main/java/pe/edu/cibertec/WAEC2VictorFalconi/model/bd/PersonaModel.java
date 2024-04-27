package pe.edu.cibertec.WAEC2VictorFalconi.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "persona")
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpersona;
    @Column(name = "nompersona")
    private String nompersona;
    @Column(name = "apepersona")
    private String apepersona;
    @Column(name = "fechnacpersona")
    private Date fechnacpersona;
}

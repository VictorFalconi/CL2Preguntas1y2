package pe.edu.cibertec.WAEC2VictorFalconi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.PersonaModel;
import pe.edu.cibertec.WAEC2VictorFalconi.repository.PersonaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonaService implements IPersonaService{
    private PersonaRepository personaRepository;
    @Override
    public List<PersonaModel> listarPersonas() {
        return personaRepository.findAll();
    }
}

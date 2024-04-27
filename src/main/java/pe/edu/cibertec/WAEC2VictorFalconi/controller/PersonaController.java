package pe.edu.cibertec.WAEC2VictorFalconi.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.PersonaModel;
import pe.edu.cibertec.WAEC2VictorFalconi.service.IPersonaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/persona")
public class PersonaController {
    private IPersonaService iPersonaService;

    @GetMapping("/get")
    @ResponseBody
    public List<PersonaModel> listPersona() {
        return iPersonaService.listarPersonas();
    }
}

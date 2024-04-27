package pe.edu.cibertec.WAEC2VictorFalconi.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.CuentaModel;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.PersonaModel;
import pe.edu.cibertec.WAEC2VictorFalconi.model.dto.request.CuentaRequest;
import pe.edu.cibertec.WAEC2VictorFalconi.model.dto.response.CuentaResponse;
import pe.edu.cibertec.WAEC2VictorFalconi.service.ICuentaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/cuenta")
public class CuentaController {
    private ICuentaService iCuentaService;

    @GetMapping("")
    public String formCuenta(Model model){
        model.addAttribute("listaCuentas", iCuentaService.listarCuentas());
        return "backoffice/cuenta/formcuenta";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<CuentaModel> listarCuentas() {
        return iCuentaService.listarCuentas();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public CuentaResponse registrarCuenta(@RequestBody CuentaRequest cuentaRequest) {
        String mensaje = "Cuenta registrada correctamente";
        boolean respuesta = true;
        try{
            CuentaModel cuentaModel = new CuentaModel();
            if(cuentaRequest.getIdcuenta() > 0) {
                cuentaModel.setIdcuenta(cuentaRequest.getIdcuenta());
            }
            cuentaModel.setNrocuenta(cuentaRequest.getNrocuenta());
            cuentaModel.setFecharegistro(cuentaRequest.getFecharegistro());
            cuentaModel.setFechavencimiento(cuentaRequest.getFechavencimiento());
            PersonaModel personaModel = new PersonaModel();
            personaModel.setIdpersona(cuentaRequest.getIdpersona());
            cuentaModel.setPersonaModel(personaModel);
            iCuentaService.registrarCuenta(cuentaModel);
        }
        catch(Exception ex) {
            mensaje=ex.getMessage();
            respuesta= false;
        }
        return CuentaResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}

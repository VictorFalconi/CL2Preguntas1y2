package pe.edu.cibertec.WAEC2VictorFalconi.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.RolModel;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.UsuarioModel;
import pe.edu.cibertec.WAEC2VictorFalconi.repository.RolRepository;
import pe.edu.cibertec.WAEC2VictorFalconi.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder=
            new BCryptPasswordEncoder();



    public UsuarioModel findUserByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public UsuarioModel findUserByUserName(String username){
        return usuarioRepository.findByNomusuario(username);
    }

    public UsuarioModel saveUser(UsuarioModel usuarioModel){
        usuarioModel.setPassword(bCryptPasswordEncoder.encode(
                usuarioModel.getPassword()));
        usuarioModel.setActivo(true);
        RolModel usuarioRol = rolRepository.findByNomrol("USER");
        usuarioModel.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuarioModel);
    }
}

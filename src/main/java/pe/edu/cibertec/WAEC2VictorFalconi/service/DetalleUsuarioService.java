package pe.edu.cibertec.WAEC2VictorFalconi.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.RolModel;
import pe.edu.cibertec.WAEC2VictorFalconi.model.bd.UsuarioModel;
import pe.edu.cibertec.WAEC2VictorFalconi.model.security.UsuarioSecurity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {

    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel usuario = usuarioService.findUserByUserName(username);
        return autenticacionUsuario(
                usuario, obtenerListaRolesUsuario(usuario.getRoles())
        );
    }

    private List<GrantedAuthority> obtenerListaRolesUsuario(Set<RolModel> listRoles){
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (RolModel rol : listRoles) {
            roles.add(new SimpleGrantedAuthority(rol.getNomrol()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UsuarioSecurity autenticacionUsuario(
            UsuarioModel usuario, List<GrantedAuthority> authorityList){
        UsuarioSecurity usuarioSecurity = new UsuarioSecurity(usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true, authorityList);
        usuarioSecurity.setNomusuario(usuario.getNomusuario());
        return usuarioSecurity;
    }
}

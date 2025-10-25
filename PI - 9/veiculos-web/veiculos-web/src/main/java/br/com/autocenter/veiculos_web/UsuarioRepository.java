package br.com.autocenter.veiculos_web;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.autocenter.veiculos_web.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByTipo(String tipo);
    Usuario findByEmail(String email);
}

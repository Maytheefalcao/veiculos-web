package br.com.autocenter.veiculos_web;

import br.com.autocenter.veiculos_web.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario salvar(Usuario usuario);
    List<Usuario> listarTodos();
    List<Usuario> listarPorTipo(String tipo);
    void excluir(Long id);
    Usuario buscarPorEmail(String email);
}

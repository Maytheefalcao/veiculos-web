package br.com.autocenter.veiculos_web;

import br.com.autocenter.veiculos_web.Usuario;
import br.com.autocenter.veiculos_web.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    private final UsuarioRepository repo;

    public UsuarioServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null || usuario.getSenha() == null) {
            throw new IllegalArgumentException("Nome, e-mail e senha são obrigatórios!");
        }
        return repo.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    @Override
    public List<Usuario> listarPorTipo(String tipo) {
        return repo.findByTipo(tipo);
    }

    @Override
    public void excluir(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return repo.findByEmail(email);
    }    
}

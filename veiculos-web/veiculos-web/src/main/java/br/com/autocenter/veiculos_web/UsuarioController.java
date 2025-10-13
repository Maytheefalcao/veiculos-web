package br.com.autocenter.veiculos_web;

import br.com.autocenter.veiculos_web.Usuario;
import br.com.autocenter.veiculos_web.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Criar usuário
    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    // Listar todos
    @GetMapping
    public List<Usuario> listarTodos() {
        return service.listarTodos();
    }

    // Filtrar por tipo
    @GetMapping("/tipo/{tipo}")
    public List<Usuario> listarPorTipo(@PathVariable String tipo) {
        return service.listarPorTipo(tipo);
    }

    // Buscar por e-mail
    @GetMapping("/email/{email}")
    public Usuario buscarPorEmail(@PathVariable String email) {
        return service.buscarPorEmail(email);
    }

    // Excluir usuário
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

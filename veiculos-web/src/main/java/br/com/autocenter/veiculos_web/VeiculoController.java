package br.com.autocenter.veiculos_web;

import br.com.autocenter.veiculos_web.Veiculo;
import br.com.autocenter.veiculos_web.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo v) {
        return service.salvar(v);
    }

    @GetMapping
    public List<Veiculo> listar() {
        return service.listarTodos();
    }

    @GetMapping("/status/{status}")
    public List<Veiculo> listarPorStatus(@PathVariable String status) {
        return service.listarPorStatus(status);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

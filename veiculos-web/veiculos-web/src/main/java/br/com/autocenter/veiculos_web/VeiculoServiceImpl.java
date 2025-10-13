package br.com.autocenter.veiculos_web;

import br.com.autocenter.veiculos_web.Veiculo;
import br.com.autocenter.veiculos_web.VeiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService{

    private final VeiculoRepository repo;

    public VeiculoServiceImpl(VeiculoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Veiculo salvar(Veiculo v) {
        if (v.getMarca() == null || v.getModelo() == null) {
            throw new IllegalArgumentException("Marca e modelo são obrigatórios!");
        }
        return repo.save(v);
    }

    @Override
    public List<Veiculo> listarTodos() {
        return repo.findAll();
    }

    @Override
    public List<Veiculo> listarPorStatus(String status) {
        return repo.findByStatus(status);
    }

    @Override
    public void excluir(Long id) {
        repo.deleteById(id);
    }

    // Exemplo de método simples para teste unitário
    public double calcularPrecoComDesconto(double preco, double percentualDesconto) {
        if (percentualDesconto < 0 || percentualDesconto > 100) {
            throw new IllegalArgumentException("Desconto inválido");
        }
        return preco - (preco * percentualDesconto / 100);
    }
}

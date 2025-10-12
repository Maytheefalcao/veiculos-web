package br.com.autocenter.veiculos_web;

import br.com.autocenter.veiculos_web.Veiculo;
import java.util.List;


public interface VeiculoService {
    Veiculo salvar(Veiculo v);
    List<Veiculo> listarTodos();
    List<Veiculo> listarPorStatus(String status);
    void excluir(Long id);
}

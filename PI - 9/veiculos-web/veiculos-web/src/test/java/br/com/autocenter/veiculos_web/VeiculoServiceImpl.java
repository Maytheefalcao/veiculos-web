package br.com.autocenter.veiculos_web;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class VeiculoServiceImpl {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    // Método que salva o veículo
    public Veiculo salvar(Veiculo veiculo) {
        if (veiculo.getMarca() == null || veiculo.getModelo() == null) {
            throw new IllegalArgumentException("Marca e modelo não podem ser nulos");
        }
        return veiculoRepository.save(veiculo);
    }
}
package br.com.autocenter.veiculos_web;

public class VeiculoServiceImpl {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    // Método que salva o veículo
    public Veiculo salvar(Veiculo veiculo) {
        // Validação básica
        if (veiculo.getMarca() == null || veiculo.getModelo() == null) {
            throw new IllegalArgumentException("Marca e modelo não podem ser nulos");
        }
        return veiculoRepository.save(veiculo);
    }
}
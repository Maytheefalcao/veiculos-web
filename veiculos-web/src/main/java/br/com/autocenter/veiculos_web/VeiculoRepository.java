package br.com.autocenter.veiculos_web;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.autocenter.veiculos_web.Veiculo;
import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    List<Veiculo> findByStatus(String status);
}

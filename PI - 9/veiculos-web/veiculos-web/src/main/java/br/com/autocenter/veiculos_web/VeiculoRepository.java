package br.com.autocenter.veiculos_web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.autocenter.veiculos_web.Veiculo;
import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    List<Veiculo> findByStatus(String status);
}

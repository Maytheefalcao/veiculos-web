package br.com.autocenter.veiculos_web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VeiculoServiceImplTest {

    @Test
    public void deveSalvarVeiculoComDadosValidos() {
        VeiculoRepository repoMock = Mockito.mock(VeiculoRepository.class);
        VeiculoServiceImpl service = new VeiculoServiceImpl(repoMock);

        Veiculo v = new Veiculo();
        v.setMarca("Toyota");
        v.setModelo("Corolla");
        v.setStatus("Disponível");

        Mockito.when(repoMock.save(v)).thenReturn(v);

        Veiculo salvo = service.salvar(v);

        Assertions.assertNotNull(salvo);
        Assertions.assertEquals("Toyota", salvo.getMarca());
        Mockito.verify(repoMock, Mockito.times(1)).save(v);
    }

    @Test
    public void deveLancarExcecaoQuandoMarcaOuModeloForemNulos() {
        VeiculoRepository repoMock = Mockito.mock(VeiculoRepository.class);
        VeiculoServiceImpl service = new VeiculoServiceImpl(repoMock);

        Veiculo v = new Veiculo();
        v.setMarca(null);
        v.setModelo("Civic");

        Assertions.assertThrows(IllegalArgumentException.class, () -> service.salvar(v));
    }
}
package dio.padroesprojeto.services.imp;

import dio.padroesprojeto.models.Cliente;
import dio.padroesprojeto.models.Endereco;
import dio.padroesprojeto.services.ClienteService;
import dio.padroesprojeto.services.EnderecoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnderecoServiceImpTest{

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EnderecoService enderecoService;

    @Test
    void enderecosDoEstadoDoPara(){
        //Arrange
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        endereco.setCep("68440000");
        cliente.setEndereco(endereco);
        //Act
        clienteService.inserir(cliente);
        Iterable<Endereco> listaEnderecos = enderecoService.listarPorUF("pa");
        int tamanho = ((Collection<?>)listaEnderecos).size();
        //Assert
        Assertions.assertEquals(1, tamanho);
    }
}
package dio.padroesprojeto.services.imp;

import dio.padroesprojeto.repositories.ClienteRepository;
import dio.padroesprojeto.repositories.EnderecoRepository;
import dio.padroesprojeto.models.Cliente;
import dio.padroesprojeto.models.Endereco;
import dio.padroesprojeto.services.ClienteService;
import dio.padroesprojeto.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
         Optional<Cliente> clienteOptional = clienteRepository.findById(id);
         if(clienteOptional.isPresent()){
             inserir(cliente);
         }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}

package dio.padroesprojeto.services.imp;

import dio.padroesprojeto.Repositories.EnderecoRepository;
import dio.padroesprojeto.models.Endereco;
import dio.padroesprojeto.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImp implements EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public Iterable<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarPorCep(String cep) {
        cep = cep.substring(0, 5) + "-" + cep.substring(5);
        return enderecoRepository.findById(cep).get();
    }
    @Override
    public Iterable<Endereco> listarPorUF(String uf){
        return enderecoRepository.findEnderecosByUf(uf.toUpperCase());
    }
}

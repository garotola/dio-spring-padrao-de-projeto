package dio.padroesprojeto.services;

import dio.padroesprojeto.models.Cliente;
import dio.padroesprojeto.models.Endereco;

public interface EnderecoService {
    Iterable<Endereco> buscarTodos();
    Endereco buscarPorCep(String cep);
    Iterable<Endereco> listarPorUF(String uf);
}

package dio.padroesprojeto.repositories;

import dio.padroesprojeto.models.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
    Iterable<Endereco> findEnderecosByUf(String uf);
}

package dio.padroesprojeto.Repositories;

import dio.padroesprojeto.models.Endereco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
    Iterable<Endereco> findEnderecosByUf(String uf);
}

package dio.padroesprojeto.controllers;


import dio.padroesprojeto.models.Endereco;
import dio.padroesprojeto.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
public class EnderecoRestController {
    @Autowired
    private EnderecoService enderecoService;
    @GetMapping
    public ResponseEntity<Iterable<Endereco>> buscarTodos(){
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> buscarPorCep(@PathVariable String cep){
        return ResponseEntity.ok(enderecoService.buscarPorCep(cep));
    }
    @GetMapping("/uf/{uf}")
    public ResponseEntity<Iterable<Endereco>> listarPorUf(@PathVariable String uf){
        return ResponseEntity.ok(enderecoService.listarPorUF(uf));
    }
}

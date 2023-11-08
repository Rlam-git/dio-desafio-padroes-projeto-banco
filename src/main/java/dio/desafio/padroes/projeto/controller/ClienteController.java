package dio.desafio.padroes.projeto.controller;

import dio.desafio.padroes.projeto.faced.ClientFaced;
import dio.desafio.padroes.projeto.model.dto.ClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {
  private final ClientFaced faced;

  public ClienteController(ClientFaced faced) {
    this.faced = faced;
  }

  @GetMapping
  public ResponseEntity<List<ClientDTO>> listar(){
    return new ResponseEntity<>(this.faced.list(), HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO){
    return new ResponseEntity<>(this.faced.save(clientDTO), HttpStatus.CREATED);
  }
  @GetMapping("/{id}")
  public ResponseEntity<ClientDTO> findById(@PathVariable("id") Long id){
    return new ResponseEntity<>(faced.findById(id),HttpStatus.OK);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
    faced.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}

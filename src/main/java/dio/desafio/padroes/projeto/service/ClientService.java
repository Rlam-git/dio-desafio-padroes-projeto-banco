package dio.desafio.padroes.projeto.service;

import dio.desafio.padroes.projeto.model.Client;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface ClientService {
  Client save(Client clientDTO);
  List<Client> list();
  Client findById(Long id) throws EntityNotFoundException;
  void deleteById(Long id);
  boolean existsByName(String name);

}

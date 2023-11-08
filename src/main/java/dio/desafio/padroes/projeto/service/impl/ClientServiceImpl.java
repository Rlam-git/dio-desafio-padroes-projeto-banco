package dio.desafio.padroes.projeto.service.impl;

import dio.desafio.padroes.projeto.model.Client;
import dio.desafio.padroes.projeto.repository.ClientRepository;
import dio.desafio.padroes.projeto.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository repository;

  @Override
  public Client save(final Client clientDTO) {
    return this.repository.save(clientDTO);
  }
  @Override
  public List<Client> list() {
    return this.repository.findAll();
  }
  @Override
  public Client findById(final Long id) throws EntityNotFoundException{
    return this.repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Cliente com id "+id+" não existe"));
  }
  @Override
  public void deleteById(final Long id) {
    this.repository.deleteById(id);
  }

  @Override
  public boolean existsByName(String name) {
    return this.repository.existsByName(name);
  }

}

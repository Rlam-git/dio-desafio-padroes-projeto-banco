package dio.desafio.padroes.projeto.faced.impl;

import dio.desafio.padroes.projeto.exception.AlreadyRegisteredException;
import dio.desafio.padroes.projeto.faced.ClientFaced;
import dio.desafio.padroes.projeto.mapper.ClientMapper;
import dio.desafio.padroes.projeto.model.Client;
import dio.desafio.padroes.projeto.model.dto.ClientDTO;
import dio.desafio.padroes.projeto.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteFacedImpl implements ClientFaced {

  private final ClientService service;

  public ClienteFacedImpl(ClientService service) {
    this.service = service;
  }
  @Override
  public ClientDTO save(final ClientDTO clientDTO) {
    boolean alreadyRegistered = service.existsByName(clientDTO.getName());
    if(alreadyRegistered){
      throw new AlreadyRegisteredException("Cliente já registrado","Nome: " + clientDTO.getName());
    }
    Client newClient = ClientMapper.INSTANCE.clientDTOToCliente(clientDTO);
    return ClientMapper.INSTANCE.clientToClientDTO(this.service.save(newClient));
  }
  @Override
  public List<ClientDTO> list() {
    List<Client> clients = this.service.list();
    return ClientMapper.INSTANCE.toClientDtoList(clients);
  }
  @Override
  public ClientDTO findById(Long id) throws EntityNotFoundException {
    Client savedClient = this.service.findById(id);
    return ClientMapper.INSTANCE.clientToClientDTO(savedClient);
  }
  @Override
  public void deleteById(Long id) {
    this.service.deleteById(id);
  }
}

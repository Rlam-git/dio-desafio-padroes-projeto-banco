package dio.desafio.padroes.projeto.faced;

import dio.desafio.padroes.projeto.model.Client;
import dio.desafio.padroes.projeto.model.dto.ClientDTO;

import java.util.List;

public interface ClientFaced {
  ClientDTO save(ClientDTO client);
  List<ClientDTO> list();
  ClientDTO findById(Long id);
  void deleteById(Long id);

}

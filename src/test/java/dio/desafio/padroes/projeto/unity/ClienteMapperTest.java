package dio.desafio.padroes.projeto.unity;

import dio.desafio.padroes.projeto.mapper.ClientMapper;
import dio.desafio.padroes.projeto.model.Client;
import dio.desafio.padroes.projeto.model.dto.ClientDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClienteMapperTest {

  private final Long ID = 1L;

  @Test
  public void shouldMapClientToDto(){

    Client client = new Client("Diogenes Develop","00110001000");
    client.setId(ID);

    ClientDTO clientDTO = ClientMapper.INSTANCE.clientToClientDTO(client);

    Assertions.assertNotNull(clientDTO);
    Assertions.assertEquals(clientDTO.getName(),client.getName());
    Assertions.assertEquals(clientDTO.getTelephone(),client.getTelephone());

  }

  @Test
  public void shouldMapClientDTOToEntity(){

    ClientDTO clientDTO = new ClientDTO("Diogenes Develop","00110001000");

    Client cliente = ClientMapper.INSTANCE.clientDTOToCliente(clientDTO);

    Assertions.assertNotNull(cliente);
    Assertions.assertEquals(cliente.getName(),clientDTO.getName());
    Assertions.assertEquals(cliente.getTelephone(),clientDTO.getTelephone());

  }

}

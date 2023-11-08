package dio.desafio.padroes.projeto.unity;

import dio.desafio.padroes.projeto.model.Client;
import dio.desafio.padroes.projeto.repository.ClientRepository;
import dio.desafio.padroes.projeto.service.impl.ClientServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {
  @Mock
  private ClientRepository repository;
  @InjectMocks
  private ClientServiceImpl service;
  private static final Long ID = 1L;

  @Test
  public void shouldSaveNewClientSuccessfully(){
    Client newClient = new Client("Diogenes Develop","081900000000");
    Client expectedClient = new Client("Diogenes Develop","081900000000");
    expectedClient.setId(ID);
    Mockito.when(repository.save(Mockito.any())).thenReturn(expectedClient);
    Client saved = this.service.save(newClient);
    Assertions.assertEquals(expectedClient,saved);
  }

  @Test
  public void shouldReturnTheClientWhenSearchingForTheId(){
    Client expectedClient = new Client("Diogenes Develop","081900000000");
    expectedClient.setId(ID);
    Mockito.when(this.repository.findById(Mockito.any())).thenReturn(Optional.of(expectedClient));
    Client returneClient = this.service.findById(ID);
    Assertions.assertEquals(expectedClient,returneClient);
  }

  @Test
  public void shouldReturnTheEntityNotFoundExceptionWhenSearchingForIdNotExist(){
    Mockito.when(this.repository.findById(ID)).thenReturn(Optional.empty());
    Assertions.assertThrows(EntityNotFoundException.class,()-> this.service.findById(ID));
  }

  @Test
  public void shouldReturnTheEntityNotFoundExceptionWhenUpdateClientIdNotExist(){
    Mockito.when(this.repository.findById(ID)).thenReturn(Optional.empty());
    Assertions.assertThrows(EntityNotFoundException.class,()-> this.service.findById(ID));
  }

}

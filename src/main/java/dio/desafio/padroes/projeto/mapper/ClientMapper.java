package dio.desafio.padroes.projeto.mapper;

import dio.desafio.padroes.projeto.model.Client;
import dio.desafio.padroes.projeto.model.dto.ClientDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

  ClientDTO clientToClientDTO(Client client);
  Client clientDTOToCliente(ClientDTO clientDTO);

  List<ClientDTO> toClientDtoList(List<Client> clients);

}

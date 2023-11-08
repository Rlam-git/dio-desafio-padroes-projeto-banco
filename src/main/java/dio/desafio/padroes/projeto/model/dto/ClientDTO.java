package dio.desafio.padroes.projeto.model.dto;

import jakarta.validation.constraints.NotNull;

public class ClientDTO {

  @NotNull(message = "Name not null")
  private String name;
  @NotNull(message = "telefone not null")
  private String telephone;

  public ClientDTO(String name, String telephone) {
    this.name = name;
    this.telephone = telephone;
  }

  public ClientDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  @Override
  public String toString() {
    return "ClientDTO{" +
      "name='" + name + '\'' +
      ", telephone='" + telephone + '\'' +
      '}';
  }
}

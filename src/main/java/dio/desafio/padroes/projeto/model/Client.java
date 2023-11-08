package dio.desafio.padroes.projeto.model;

import jakarta.persistence.*;

@Entity(name = "tb_cliente")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false,length = 125)
  private String name;

  @Column(nullable = false,length = 12)
  private String telephone;

  public Client(String name, String telephone) {
    this.name = name;
    this.telephone = telephone;
  }

  public Client() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    return "Client{" +
      "id=" + id +
      ", nome='" + name + '\'' +
      ", telefone='" + telephone + '\'' +
      '}';
  }
}

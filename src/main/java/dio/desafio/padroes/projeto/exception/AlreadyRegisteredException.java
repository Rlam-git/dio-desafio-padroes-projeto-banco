package dio.desafio.padroes.projeto.exception;

public class AlreadyRegisteredException extends RuntimeException{

  private String menssagem;
  private String details;


  public AlreadyRegisteredException(String menssagem, String details){
    this.menssagem = menssagem;
    this.details = details;
  }

  public String getMenssagem() {
    return menssagem;
  }


  public String getDetails() {
    return details;
  }
}

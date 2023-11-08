package dio.desafio.padroes.projeto.exception;

import java.time.LocalDateTime;

public class ResponseExceptionBuild {
  private String titulo;
  private int status;
  private String detalhes;
  private String mensagem;
  private LocalDateTime tempo;

  public ResponseExceptionBuild(){

  }

  private ResponseExceptionBuild(String titulo, int status, String detalhes, String mensagem, LocalDateTime tempo) {
    this.titulo = titulo;
    this.status = status;
    this.detalhes = detalhes;
    this.mensagem = mensagem;
    this.tempo = tempo;
  }

  public ResponseExceptionBuild setTitulo(String titulo) {
    this.titulo = titulo;
    return this;
  }

  public ResponseExceptionBuild setStatus(int status) {
    this.status = status;
    return this;
  }

  public ResponseExceptionBuild setDetalhes(String detalhes) {
    this.detalhes = detalhes;
    return this;
  }

  public ResponseExceptionBuild setMensagem(String mensagem) {
    this.mensagem = mensagem;
    return this;
  }

  public ResponseExceptionBuild setTempo(LocalDateTime tempo) {
    this.tempo = tempo;
    return this;
  }

  public ResponseExceptionBuild build(){
    return  new ResponseExceptionBuild(this.titulo, this.status, this.detalhes, this.mensagem, this.tempo);
  }

  public String getTitulo() {
    return titulo;
  }

  public int getStatus() {
    return status;
  }

  public String getDetalhes() {
    return detalhes;
  }

  public String getMensagem() {
    return mensagem;
  }

  public LocalDateTime getTempo() {
    return tempo;
  }
}

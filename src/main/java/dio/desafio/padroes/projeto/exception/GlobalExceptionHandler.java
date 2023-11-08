package dio.desafio.padroes.projeto.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ResponseExceptionBuild> SearchNotFoundException(EntityNotFoundException snfe){
    ResponseExceptionBuild response = new ResponseExceptionBuild()
      .setTitulo("Exception")
      .setMensagem(snfe.getMessage())
      .setDetalhes(snfe.getCause().toString())
      .setStatus(404)
      .setTempo(LocalDateTime.now())
      .build();
    return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
  }
}

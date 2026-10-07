package br.com.sicapet.api.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> notFound(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body(404, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validation(MethodArgumentNotValidException e) {
        Map<String,String> errors = new LinkedHashMap<>();
        e.getBindingResult().getFieldErrors().forEach(x -> errors.put(x.getField(), x.getDefaultMessage()));
        Map<String,Object> response = new LinkedHashMap<>();
        response.put("status",400); response.put("erro","Dados inválidos"); response.put("campos",errors);
        response.put("dataHora",LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> integrity(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body(409, "CPF ou e-mail já cadastrado."));
    }

    private Map<String,Object> body(int status, String message) {
        Map<String,Object> m=new LinkedHashMap<>();
        m.put("status",status); m.put("erro",message); m.put("dataHora",LocalDateTime.now()); return m;
    }
}

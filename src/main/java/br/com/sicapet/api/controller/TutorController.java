package br.com.sicapet.api.controller;
import br.com.sicapet.api.dto.*;
import br.com.sicapet.api.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tutores")
@CrossOrigin(origins="*")
public class TutorController {
    private final TutorService service;
    public TutorController(TutorService service){this.service=service;}

    @PostMapping
    public ResponseEntity<TutorResponse> criar(@Valid @RequestBody TutorRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }
    @GetMapping public List<TutorResponse> listar(){return service.listar();}
    @GetMapping("/{id}") public TutorResponse buscar(@PathVariable Long id){return service.buscarResponse(id);}
}

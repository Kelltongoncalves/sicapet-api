package br.com.sicapet.api.controller;
import br.com.sicapet.api.dto.*;
import br.com.sicapet.api.entity.TipoAnimal;
import br.com.sicapet.api.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/animais")
@CrossOrigin(origins="*")
public class AnimalController {
    private final AnimalService service;
    public AnimalController(AnimalService service){this.service=service;}

    @PostMapping
    public ResponseEntity<AnimalResponse> criar(@Valid @RequestBody AnimalRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }
    @GetMapping
    public List<AnimalResponse> listar(@RequestParam(required=false) String bairro,
                                       @RequestParam(required=false) TipoAnimal tipo){
        return service.listar(bairro,tipo);
    }
    @GetMapping("/{id}") public AnimalResponse buscar(@PathVariable Long id){return service.buscar(id);}
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluir(@PathVariable Long id){service.excluir(id);}
}

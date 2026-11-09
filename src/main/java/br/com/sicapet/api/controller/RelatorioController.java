package br.com.sicapet.api.controller;
import br.com.sicapet.api.dto.RelatorioResponse;
import br.com.sicapet.api.entity.TipoAnimal;
import br.com.sicapet.api.service.AnimalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/relatorios")
@CrossOrigin(origins="*")
public class RelatorioController {
    private final AnimalService service;
    public RelatorioController(AnimalService service){this.service=service;}
    @GetMapping("/animais")
    public RelatorioResponse animais(@RequestParam(required=false) String bairro,
                                     @RequestParam(required=false) TipoAnimal tipo){
        return service.relatorio(bairro,tipo);
    }
}

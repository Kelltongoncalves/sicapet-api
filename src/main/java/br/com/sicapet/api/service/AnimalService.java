package br.com.sicapet.api.service;

import br.com.sicapet.api.dto.*;
import br.com.sicapet.api.entity.*;
import br.com.sicapet.api.exception.ResourceNotFoundException;
import br.com.sicapet.api.repository.AnimalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final TutorService tutorService;
    public AnimalService(AnimalRepository animalRepository, TutorService tutorService){
        this.animalRepository=animalRepository; this.tutorService=tutorService;
    }

    public AnimalResponse criar(AnimalRequest r){
        Tutor tutor=tutorService.buscar(r.idTutor());
        Animal a=new Animal(); a.setTipo(r.tipo()); a.setSexo(r.sexo()); a.setQuantidade(r.quantidade());
        a.setTutor(tutor); a.setBairro(tutor.getBairro());
        return toResponse(animalRepository.save(a));
    }
    public List<AnimalResponse> listar(String bairro, TipoAnimal tipo){
        List<Animal> list;
        if(bairro!=null && !bairro.isBlank() && tipo!=null) list=animalRepository.findByBairroContainingIgnoreCaseAndTipo(bairro,tipo);
        else if(bairro!=null && !bairro.isBlank()) list=animalRepository.findByBairroContainingIgnoreCase(bairro);
        else if(tipo!=null) list=animalRepository.findByTipo(tipo);
        else list=animalRepository.findAll();
        return list.stream().map(this::toResponse).toList();
    }
    public AnimalResponse buscar(Long id){
        return toResponse(animalRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Animal não encontrado: "+id)));
    }
    public void excluir(Long id){if(!animalRepository.existsById(id)) throw new ResourceNotFoundException("Animal não encontrado: "+id); animalRepository.deleteById(id);}
    public RelatorioResponse relatorio(String bairro, TipoAnimal tipo){
        long total=0,caes=0,gatos=0;
        for(AnimalResponse a:listar(bairro,tipo)){
            total+=a.quantidade();
            if(a.tipo()==TipoAnimal.CAO) caes+=a.quantidade();
            if(a.tipo()==TipoAnimal.GATO) gatos+=a.quantidade();
        }
        return new RelatorioResponse(total,caes,gatos);
    }
    private AnimalResponse toResponse(Animal a){
        return new AnimalResponse(a.getId(),a.getTipo(),a.getSexo(),a.getQuantidade(),
            a.getTutor().getId(),a.getTutor().getNome(),a.getBairro());
    }
}

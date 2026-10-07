package br.com.sicapet.api.service;

import br.com.sicapet.api.dto.*;
import br.com.sicapet.api.entity.Tutor;
import br.com.sicapet.api.exception.ResourceNotFoundException;
import br.com.sicapet.api.repository.TutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TutorService {
    private final TutorRepository repository;
    public TutorService(TutorRepository repository){this.repository=repository;}

    public TutorResponse criar(TutorRequest r){
        Tutor t=new Tutor(); t.setNome(r.nome()); t.setCpf(r.cpf()); t.setTelefone(r.telefone());
        t.setEmail(r.email()); t.setBairro(r.bairro());
        return toResponse(repository.save(t));
    }
    public List<TutorResponse> listar(){return repository.findAll().stream().map(this::toResponse).toList();}
    public Tutor buscar(Long id){return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tutor não encontrado: "+id));}
    public TutorResponse buscarResponse(Long id){return toResponse(buscar(id));}
    private TutorResponse toResponse(Tutor t){return new TutorResponse(t.getId(),t.getNome(),t.getCpf(),t.getTelefone(),t.getEmail(),t.getBairro());}
}

package br.com.sicapet.api.repository;
import br.com.sicapet.api.entity.Animal;
import br.com.sicapet.api.entity.TipoAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByBairroContainingIgnoreCase(String bairro);
    List<Animal> findByTipo(TipoAnimal tipo);
    List<Animal> findByBairroContainingIgnoreCaseAndTipo(String bairro, TipoAnimal tipo);
    long countByTipo(TipoAnimal tipo);
}

package br.com.sicapet.api.repository;
import br.com.sicapet.api.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    Optional<Tutor> findByCpf(String cpf);
}

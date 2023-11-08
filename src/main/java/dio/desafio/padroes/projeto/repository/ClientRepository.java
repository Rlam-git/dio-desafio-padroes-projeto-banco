package dio.desafio.padroes.projeto.repository;

import dio.desafio.padroes.projeto.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
   boolean existsByName(String name);
}

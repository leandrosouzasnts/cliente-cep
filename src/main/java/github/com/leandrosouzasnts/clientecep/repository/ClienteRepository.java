package github.com.leandrosouzasnts.clientecep.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import github.com.leandrosouzasnts.clientecep.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
 
}

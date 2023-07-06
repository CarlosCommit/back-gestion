package comm.xuxuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comm.xuxuy.model.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {

}

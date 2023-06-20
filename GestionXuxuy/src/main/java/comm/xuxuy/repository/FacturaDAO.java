package comm.xuxuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comm.xuxuy.model.Factura;

@Repository
public interface FacturaDAO extends JpaRepository<Factura, Long>{

	
	
}

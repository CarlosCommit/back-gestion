package comm.xuxuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comm.xuxuy.model.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long>  {

	public Producto findByNombre(String nombre);
}

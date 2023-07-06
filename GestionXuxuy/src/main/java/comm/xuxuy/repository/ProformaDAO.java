package comm.xuxuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comm.xuxuy.model.Proforma;

@Repository
public interface ProformaDAO extends JpaRepository<Proforma, Long> {

}

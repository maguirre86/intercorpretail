package pe.com.intercorpretail.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.intercorpretail.clientes.dao.ClienteDao;

public interface ClienteRepository extends JpaRepository<ClienteDao, Long> {

}

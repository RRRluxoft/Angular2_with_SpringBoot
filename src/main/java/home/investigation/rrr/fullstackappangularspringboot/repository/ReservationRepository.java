package home.investigation.rrr.fullstackappangularspringboot.repository;

import home.investigation.rrr.fullstackappangularspringboot.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long>{
}

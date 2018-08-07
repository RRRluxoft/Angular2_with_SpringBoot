package home.investigation.rrr.fullstackappangularspringboot.repository;

import home.investigation.rrr.fullstackappangularspringboot.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
    List<RoomEntity> getById(Long id);
}

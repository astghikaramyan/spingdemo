package am.bdgjpasping.repository;

import am.bdgjpasping.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 12.11.2020.
 */
@Repository
public interface PassengerRepo extends JpaRepository<PassengerEntity, Long> {
}

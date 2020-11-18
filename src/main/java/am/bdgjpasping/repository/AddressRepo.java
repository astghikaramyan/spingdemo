package am.bdgjpasping.repository;

import am.bdgjpasping.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 12.11.2020.
 */
@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Long> {
}

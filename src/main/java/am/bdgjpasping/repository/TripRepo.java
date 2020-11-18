package am.bdgjpasping.repository;

import am.bdgjpasping.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 12.11.2020.
 */
@Repository
public interface TripRepo extends JpaRepository<TripEntity, Long> {
    @Query(value = "SELECT u FROM TripEntity u WHERE u.town_from = ?townFrom", nativeQuery = true)
    List<TripEntity> getTripByFromCity(String townFrom);

    @Query(value = "SELECT u FROM TripEntity u WHERE u.town_to = ?townTo", nativeQuery = true)
    List<TripEntity> getTripByToCity(String townTo);

    @Query(value = "SELECT u FROM TripEntity u WHERE u.trip_number = ?tripNumber",nativeQuery = true)
    TripEntity getTripByTripNumber(Long tripNumber);



}
//https://bezkoder.com/spring-boot-pagination-filter-jpa-pageable/
//https://www.baeldung.com/spring-data-jpa-pagination-sorting
//https://attacomsian.com/blog/spring-data-jpa-query-annotation
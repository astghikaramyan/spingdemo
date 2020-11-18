package am.bdgjpasping.service;




import am.bdgjpasping.entity.PassengerEntity;
import am.bdgjpasping.entity.TripEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 17.09.2020.
 */
public interface TripService {
    Optional<TripEntity> getById(long id) throws SQLException;
    Set<TripEntity>getAll() throws SQLException;
    Set<TripEntity> get(int page, int perPage, String sort) throws SQLException;
    TripEntity save(TripEntity passenger) throws SQLException;
    TripEntity update(TripEntity passenger) throws SQLException;
    void delete(long tripId) throws SQLException;
    List<TripEntity>getTripsFrom(String city) throws SQLException;
    List<TripEntity> getTripsTo(String city) throws SQLException;
    Set<PassengerEntity> getPassengersOfTrip(long tripNumber) throws SQLException;
//    void registerTrip(TripEntity trip, PassengerEntity passenger) throws SQLException;
//    void cancelTrip(long passengerId, long tripNumber) throws SQLException;

}

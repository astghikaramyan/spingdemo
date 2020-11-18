package am.bdgjpasping.service;





import am.bdgjpasping.entity.PassengerEntity;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 17.09.2020.
 */
public interface PassengerService {
    Optional<PassengerEntity> getById(long id) throws SQLException;
    Set<PassengerEntity> getAll() throws SQLException;
    Set<PassengerEntity>get(int page, int perPage, String sort) throws SQLException;
    PassengerEntity save(PassengerEntity passengerEntity) throws SQLException;
    PassengerEntity update(PassengerEntity passengerEntity) throws SQLException;
    void delete(long passengerId) throws SQLException;


}

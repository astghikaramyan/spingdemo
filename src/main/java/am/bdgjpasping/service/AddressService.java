package am.bdgjpasping.service;




import am.bdgjpasping.entity.AddressEntity;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 20.09.2020.
 */
public interface AddressService {
    Optional<AddressEntity> getById(long id) throws SQLException;
    Set<AddressEntity> getAll() throws SQLException;
    AddressEntity save(AddressEntity addressEntity) throws SQLException;
    AddressEntity update(AddressEntity addressEntity) throws SQLException;
    void delete(long addressId)throws SQLException;
}

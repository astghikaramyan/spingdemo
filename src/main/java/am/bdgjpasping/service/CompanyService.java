package am.bdgjpasping.service;





import am.bdgjpasping.entity.CompanyEntity;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by User on 17.09.2020.
 */
public interface CompanyService {
    Optional<CompanyEntity> getById(long id) throws SQLException;
    Set<CompanyEntity> getAll() throws SQLException;
    Set<CompanyEntity>get(int page, int perPage, String sort) throws SQLException;
    CompanyEntity save(CompanyEntity passenger) throws SQLException;
    CompanyEntity update(CompanyEntity passenger) throws SQLException;
    void delete(long companyId) throws SQLException;

}

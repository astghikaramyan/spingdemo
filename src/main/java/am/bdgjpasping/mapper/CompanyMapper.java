package am.bdgjpasping.mapper;


import am.bdgjpasping.dao.CompanyDao;
import am.bdgjpasping.entity.CompanyEntity;

/**
 * Created by User on 13.11.2020.
 */
@org.mapstruct.Mapper(componentModel = "spring")
public interface CompanyMapper extends Mapper<CompanyEntity, CompanyDao> {
}

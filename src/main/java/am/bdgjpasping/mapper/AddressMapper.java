package am.bdgjpasping.mapper;


import am.bdgjpasping.dao.AddressDao;
import am.bdgjpasping.entity.AddressEntity;

/**
 * Created by User on 13.11.2020.
 */
@org.mapstruct.Mapper(componentModel = "spring")
public interface AddressMapper extends Mapper<AddressEntity, AddressDao> {
}

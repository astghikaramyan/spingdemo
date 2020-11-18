package am.bdgjpasping.mapper;


import am.bdgjpasping.dao.PassengerDao;
import am.bdgjpasping.entity.PassengerEntity;

/**
 * Created by User on 13.11.2020.
 */
@org.mapstruct.Mapper(componentModel = "spring")
public interface PassengerMapper extends Mapper<PassengerEntity, PassengerDao> {
}

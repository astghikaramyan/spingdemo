package am.bdgjpasping.mapper;


import am.bdgjpasping.dao.TripDao;
import am.bdgjpasping.entity.TripEntity;

/**
 * Created by User on 13.11.2020.
 */
@org.mapstruct.Mapper(componentModel = "spring")
public interface TripMapper extends Mapper<TripEntity, TripDao> {
}

package am.bdgjpasping.mapper;

import java.util.List;
import java.util.Set;

/**
 * Created by User on 13.11.2020.
 */
public interface Mapper<Entity, Dto> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    List<Dto> toDtoList(List<Entity> entity);

    Set<Dto> toDtoSet(Set<Entity> entity);

    List<Entity> toEntityList(List<Dto> dto);

    Set<Entity> toEntitySet(Set<Dto> dto);
}

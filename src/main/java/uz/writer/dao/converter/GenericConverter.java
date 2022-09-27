package uz.writer.dao.converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @param <D> Dto
 * @param <E> Entity
 */
public abstract class GenericConverter<D, E> {

    private final Function<D, E> fromDto;
    private final Function<E, D> fromEntity;

    /**
     * @param fromDto    Function that converts given dto entity into the domain
     *                   entity.
     * @param fromEntity Function that converts given domain entity into the dto
     *                   entity.
     */
    public GenericConverter(final Function<D, E> fromDto, final Function<E, D> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    /**
     * @param dto DTO
     * @return The domain representation - the result of the converting function
     * application on dto entity.
     */
    public final E convertFromDto(final D dto) {
        return fromDto.apply(dto);
    }

    /**
     * @param entity E
     * @return The DTO representation - the result of the converting function
     * application on domain entity.
     */
    public final D convertFromEntity(final E entity) {
        return fromEntity.apply(entity);
    }


    /**
     * @param dtos collection of DTO entities
     * @return List of domain representation of provided entities retrieved by
     * mapping each of them with the conversion function
     */
    public final List<E> createFromDtos(final Collection<D> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    /**
     * @param entities collection of domain entities
     * @return List of domain representation of provided entities retrieved by
     * mapping each of them with the conversion function
     */
    public final List<D> createFromEntities(final Collection<E> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
}

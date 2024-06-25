package dev.leoferreira.testcontainers.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface EntityMapper<E,D> {
    D toDomain(E entity);

    E toEntity(D domain);

    default List<D> toDomainList(List<E> entities) {
        return Optional.ofNullable(entities)
                .orElse(Collections.emptyList())
                .stream()
                .map(this::toDomain)
                .toList();
    }
}

package dev.leoferreira.testcontainers.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface ResponseDTOMapper<R, D> {
    R toResponse(D domain);

    default List<R> toResponseList(List<D> domains) {
        return Optional.ofNullable(domains)
                .orElse(Collections.emptyList())
                .stream()
                .map(this::toResponse)
                .toList();
    }
}

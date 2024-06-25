package dev.leoferreira.testcontainers.mapper;

public interface RequestDTOMapper<R, D> {
    D toDomain(R requestDTO);
}

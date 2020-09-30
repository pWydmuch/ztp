package com.example.ztp0.daos;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(Long id);

    List<T> getAll();

    void save(T t);

    void update(Long id,T t);

    void delete(Long id);
}

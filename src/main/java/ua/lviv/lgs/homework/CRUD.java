package ua.lviv.lgs.homework;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {
    T create(T t);

    Optional<T> read(int id);

    List<T> readAll();

    void update(int id, T t);

    void delete(int id);
}

package pl.mmo.repositories;

import java.util.List;
import pl.mmo.entities.Gra;


public interface GryRepository {
    Gra create(Gra gra) throws GamesAlreadyExistsException;
    Gra readById(Long id) throws NoSuchGameException;
    Gra update(Gra gra) throws NoSuchGameException;
    void deleteById(Long id) throws NoSuchGameException;
    List<Gra> findAll();
}
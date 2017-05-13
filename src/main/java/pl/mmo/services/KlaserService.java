package pl.mmo.services;

import java.util.List;
import java.util.Optional;

import pl.mmo.entities.Gra;


public interface KlaserService {
    List<Gra> findAll();

    List<Gra> findAllToSell();

    Optional<Gra> findById(Long id);

    Optional<Gra> create(Gra gra);

    Optional<Gra> edit(Gra gra);

    Optional<Boolean> deleteById(Long id);

    List<Gra> findLatest3();
}

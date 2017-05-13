package pl.mmo.services;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import pl.mmo.entities.Gra;
import pl.mmo.entities.Status;
import pl.mmo.repositories.NoSuchGameException;
import pl.mmo.repositories.GamesAlreadyExistsException;
import pl.mmo.repositories.GryRepository;


@Service
@Primary
public class KlaserServiceJ8Impl implements KlaserService {

    @Autowired
    @Qualifier("lista")
    private GryRepository gry;

    @Override
    public List<Gra> findAll() {
        return gry.findAll();
    }

    @Override
    public List<Gra> findLatest3() {
        return gry.findAll().stream().sorted((a, b) -> b.getDataDodaniaGry().compareTo(a.getDataDodaniaGry())).limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Gra> findById(Long id) {
        try {
            return Optional.of(gry.readById(id));
        } catch (NoSuchGameException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Gra> create(Gra gra) {
        try {
            return Optional.of(gry.create(gra));
        } catch (GamesAlreadyExistsException e) {
            try {
                return Optional.of(gry.readById(gra.getId()));
            } catch (NoSuchGameException e1) {
                return Optional.empty();
            }
        }

    }

    @Override
    public Optional<Gra> edit(Gra gra) {
        try {
            return Optional.of(gry.update(gra));
        } catch (NoSuchGameException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Boolean> deleteById(Long id) {
        try {
            gry.deleteById(id);
            return Optional.of(Boolean.TRUE);
        } catch (NoSuchGameException e) {
            return Optional.of(Boolean.FALSE);
        }
    }

    @Override
    public List<Gra> findAllToSell() {
        return gry.findAll().stream().filter(p -> Objects.equals(p.getStatus(), Status.DO_WYPOZYCZENIA))
                .collect(Collectors.toList());
    }
}
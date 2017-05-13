package pl.mmo.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.mmo.entities.Gra;
import pl.mmo.entities.Status;


@Service
@Qualifier("lista")
public class GryRepositoryJ8Impl implements GryRepository {

    private List<Gra> gry = new ArrayList<Gra>() {
        {

            //Long id, String tytul, String autor, String krajPochodzenia, String gatunek,
            //Date dataPolskiejPremiery, BigDecimal cenaWypozyczenia, Status status
            add(Gra.dodajGre(1L, "Sim City 4", "EA Games", "Canada", "Symulacyjna", new Date(), new BigDecimal("5.5"),
                    Status.WYPOZYCZONA));
            add(Gra.dodajGre(2L, "FIFA 17", "EA Sports", "Canada", "Sportowa", new Date(), new BigDecimal("1.2"),
                    Status.DO_WYPOZYCZENIA));
            add(Gra.dodajGre(3L, "Madden 17", "EA Sports", "USA", "Sportowa", new Date(), new BigDecimal("1.8"), Status.KILKA_DOSTEPNYCH_SZTUK));
            add(Gra.dodajGre(4L, "Football Manager 2017", "SI Games", "England", "Symulacyjna", new Date(), new BigDecimal("1.4"),
                    Status.DO_WYPOZYCZENIA));
            add(Gra.dodajGre(5L, "Farmville", "Zynga", "USA", "Przeglądarkowa", new Date(), new BigDecimal("2.2"), Status.WYPOZYCZONA));
            add(Gra.dodajGre(6L, "NHL 17", "EA Sports", "Canada", "Sportowa", new Date(), new BigDecimal("1.2"), Status.WYPOZYCZONA));
        }
    };

    @Override
    public List<Gra> findAll() {
        return this.gry;
    }

    @Override
    public Gra readById(Long id) throws NoSuchGameException {
        return this.gry.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst()
                .orElseThrow(NoSuchGameException::new);
    }

    @Override
    public Gra create(Gra gra) {
        if (!gry.isEmpty()) {
            gra.setId(
                    this.gry.stream().mapToLong(p -> p.getId()).max().getAsLong() + 1);
        } else {
            gra.setId(1L);
        }
        this.gry.add(gra);
        return gra;
    }

    @Override
    public Gra update(Gra gra) throws NoSuchGameException {
        for (int i = 0; i < this.gry.size(); i++) {
            if (Objects.equals(this.gry.get(i).getId(), gra.getId())) {
                this.gry.set(i, gra);
                return gra;
            }
        }
        throw new NoSuchGameException("Nie ma takiej gry: " + gra.getId());
    }

    @Override
    public void deleteById(Long id) throws NoSuchGameException {
        for (int i = 0; i < this.gry.size(); i++) {
            if (Objects.equals(this.gry.get(i).getId(), id)) {
                this.gry.remove(i);
            }
        }
        throw new NoSuchGameException("Nie ma takiej gry: " + id);
    }

}
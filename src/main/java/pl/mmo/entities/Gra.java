package pl.mmo.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Gra {

    private Long id;
    private String gatunek;
    private String tytul;
    private String autor;
    private BigDecimal cenaWypozyczenia;
    private Date dataDodaniaGry;
    private String krajProdukcji;
    private Status status;


    public static Gra dodajGre(Long id, String tytul, String autor, String krajPochodzenia, String gatunek,
                               Date dataDodaniaGry, BigDecimal cenaWypozyczenia, Status status) {
        Gra g = new Gra();
        g.id = id;
        g.krajProdukcji = krajPochodzenia;
        g.gatunek = gatunek;
        g.tytul = tytul;
        g.autor = autor;
        g.cenaWypozyczenia = cenaWypozyczenia;
        g.dataDodaniaGry = dataDodaniaGry;
        g.status = status;
        return g;
    }

    public Long getId() {
        return id;
    }

    public String getGatunek() {
        return gatunek;
    }

    public String getTytul() {
        return tytul;
    }

    public String getAutor() {
        return autor;
    }

    public BigDecimal getCenaWypozyczenia() {
        return cenaWypozyczenia;
    }

    public Date getDataDodaniaGry() {
        return dataDodaniaGry;
    }

    public String getKrajProdukcji() {
        return krajProdukcji;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCenaWypozyczenia(BigDecimal cenaWypozyczenia) {
        this.cenaWypozyczenia = cenaWypozyczenia;
    }

    public void setDataDodaniaGry(Date dataDodaniaGry) {
        this.dataDodaniaGry = dataDodaniaGry;
    }

    public void setKrajProdukcji(String krajProdukcji) {
        this.krajProdukcji = krajProdukcji;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tytul == null) ? 0 : tytul.hashCode());
        result = prime * result + ((cenaWypozyczenia == null) ? 0 : cenaWypozyczenia.hashCode());
        result = prime * result + ((dataDodaniaGry == null) ? 0 : dataDodaniaGry.hashCode());
        result = prime * result + ((krajProdukcji == null) ? 0 : krajProdukcji.hashCode());
        result = prime * result + ((gatunek == null) ? 0 : gatunek.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Gra other = (Gra) obj;
        if (tytul == null) {
            if (other.tytul != null)
                return false;
        } else if (!tytul.equals(other.tytul))
            return false;
        if (cenaWypozyczenia == null) {
            if (other.cenaWypozyczenia != null)
                return false;
        } else if (!cenaWypozyczenia.equals(other.cenaWypozyczenia))
            return false;
        if (dataDodaniaGry == null) {
            if (other.dataDodaniaGry != null)
                return false;
        } else if (!dataDodaniaGry.equals(other.dataDodaniaGry))
            return false;
        if (krajProdukcji == null) {
            if (other.krajProdukcji != null)
                return false;
        } else if (!krajProdukcji.equals(other.krajProdukcji))
            return false;
        if (gatunek == null) {
            if (other.gatunek != null)
                return false;
        } else if (!gatunek.equals(other.gatunek))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Gra [id=" + id + ", gatunek=" + gatunek + ", Tytul=" + tytul + ", autor="
                + autor + ", cenaWypozyczenia=" + cenaWypozyczenia + ", dataDodaniaGry=" + dataDodaniaGry + ", krajProdukcji="
                + krajProdukcji + ", status=" + status + "]";
    }

}
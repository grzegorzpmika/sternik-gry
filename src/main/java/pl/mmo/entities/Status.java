package pl.mmo.entities;


public enum Status {

    WYPOZYCZONA("Gra wypożyczony"),
    DO_WYPOZYCZENIA("Gra do wypożyczenia"),
    KILKA_DOSTEPNYCH_SZTUK("Kilka dostępnych sztuk gier");


    public static final Status[] ALL = {WYPOZYCZONA, DO_WYPOZYCZENIA, KILKA_DOSTEPNYCH_SZTUK};


    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
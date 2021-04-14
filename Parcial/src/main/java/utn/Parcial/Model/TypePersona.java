package utn.Parcial.Model;

public enum TypePersona {
    JUGADOR("Jugador"),
    REPRESENTANTE("Representante");


    private String description;

    TypePersona(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public static TypePersona find(final String value) {
        for (TypePersona n : values()) {
            if (n.toString().equalsIgnoreCase(value)) {
                return n;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypeNew: %s", value));
    }
}

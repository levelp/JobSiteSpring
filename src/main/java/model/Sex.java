package model;

/**
 * Пол пользователя
 */
public enum Sex {
    MAN("Мужской"),
    WOMAN("Женский");

    private final String name;

    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

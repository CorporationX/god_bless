package school.faang.amazonorders;

public enum Status {
    NEW("Новый"),
    PROCESSED("Обработано");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package school.faang.bjs2_69541;

public enum Category {
    FOOD("Food"),
    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    OTHER("Other");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

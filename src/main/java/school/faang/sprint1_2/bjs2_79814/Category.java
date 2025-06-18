package school.faang.sprint1_2.bjs2_79814;

public enum Category {
    FOOD("Еда"),
    ELECTRONICS("Электроника"),
    CLOTHING("Одежда"),
    OTHER("Другое");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

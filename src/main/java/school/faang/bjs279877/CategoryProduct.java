package school.faang.bjs279877;

public enum CategoryProduct {
    FOOD("Еда"),
    ELECTRONIC("Электроника"),
    FOR_HOME("Для дома"),
    FOR_CAR("Для автомобиля"),
    FOR_KITCHEN("Для кухни"),
    CLOTHES("Одежда");

    private final String name;

    CategoryProduct(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

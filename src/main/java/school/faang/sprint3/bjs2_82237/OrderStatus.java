package school.faang.sprint3.bjs2_82237;

public enum OrderStatus {
    NEW("Новый"),
    PROCEED("Выполнен"),
    CANCELED("Отменен"),
    ERROR("Ошибка");

    private final String title;

    OrderStatus(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

package school.faang.amazon;

public enum OrderStatus {
    WAIT("wait"), COMPLETE("complete"), NEW("new");
    private final String name;

    OrderStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

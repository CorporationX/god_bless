package faang.school.godbless.amazon;

public class Order {
    private final int id;
    private Status status;

    public Order(int id) {
        this.id = id;
        status = Status.UNPROCESSED;
    }

    public int getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

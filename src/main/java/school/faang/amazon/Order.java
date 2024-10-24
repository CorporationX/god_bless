package school.faang.amazon;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Order {

    private final int id;
    private Status status;

    public Order(int id) {
        this.id = id;
        this.status = Status.NEW;
    }

    public enum Status {
        NEW,
        DONE
    }

    public void setStatus(Status status) {
        Objects.requireNonNull(status, "Status cannot be null");
        this.status = status;
    }
}

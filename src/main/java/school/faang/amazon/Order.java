package school.faang.amazon;

import lombok.Getter;

@Getter
public class Order {

    private final int id;
    private StatusType status;

    public Order() {
        this.id = createId();
        this.status = StatusType.NEW;
    }

    public void updateStatus(StatusType status) {
        this.status = status;
    }

    private static int baseId = 1;

    private int createId() {
        int id = baseId;
        baseId++;
        return id;
    }
}

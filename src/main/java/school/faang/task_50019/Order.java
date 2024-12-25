package school.faang.task_50019;

import lombok.Getter;
import school.faang.exception.CheckException;

@Getter
public class Order {
    private final int id;
    private String status;

    public Order(int id, String status) {
        checkStatus(status);

        this.id = id;
        this.status = status;
    }

    public void changeStatus(String status) {
        checkStatus(status);
        this.status = status;
    }

    private void checkStatus(String status) {
        if (status == null || status.isEmpty()) {
            throw new CheckException("status");
        }
    }
}

package school.faang.task_50014;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private final int id;
    private Status status;

    public synchronized void setStatus(Status status) {
        this.status = status;
    }
}

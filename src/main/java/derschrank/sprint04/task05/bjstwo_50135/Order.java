package derschrank.sprint04.task05.bjstwo_50135;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private final int id;
    private volatile Status status;

    public void changeStatus(Status status) {
        this.status = status;
    }
}

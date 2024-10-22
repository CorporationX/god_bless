package bjs2_38088;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private static Integer serialId = 1;
    private final Integer id;
    @Setter
    private Status status;

    public Order() {
        this.id = serialId++;
        this.status = Status.IN_PROGRESS;
    }
}

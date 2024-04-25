package faang.school.godbless.collectingordersamazon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private static int idFromDB = 0;
    private int id;
    private Status status;

    public Order() {
        this.id = ++idFromDB;
        this.status = Status.NOT_PROCESSED;
    }
}

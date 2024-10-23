package school.faang.sprint_4.bjs2_38283_amazon;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private static int ids = 1;
    private final int id;
    @Setter
    private Status status;

    public Order() {
        status = Status.NEW;
        id = ids;
        ids++;
    }
}

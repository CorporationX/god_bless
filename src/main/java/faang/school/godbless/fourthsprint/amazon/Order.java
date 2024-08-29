package faang.school.godbless.fourthsprint.amazon;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private final int id;
    @Setter
    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "Pending";
    }
}

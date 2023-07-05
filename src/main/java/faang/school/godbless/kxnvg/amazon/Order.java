package faang.school.godbless.kxnvg.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private int id;
    private Status status;

    public Order(int id) {
        this.id = id;
        this.status = Status.AWAITING_CONFIRMATION;
    }
}

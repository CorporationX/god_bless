package faang.school.godbless.BJS2_24650;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order{
    private int id;
    private STATUS status;

    public Order(int id) {
        this.id = id;
        this.status = STATUS.IN_PROGRESS;
    }
}

package faang.school.godbless.bjs2_24753;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    private int status;

    public Order(int id) {
        this.id = id;
    }
}

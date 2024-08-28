package faang.school.godbless.BJS2_24810;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Order {
    private int id;
    private String status;

    public Order(int id) {
        this.id = id;
    }
}

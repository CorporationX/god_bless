package school.faang.task_50072;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
    private int id;
    private String status;
    private static int indx;

    public Order(String status) {
        this.status = status;
        this.id = ++indx;
    }
}

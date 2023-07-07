package faang.school.godbless.sprint5.collectOrders.classes;

import faang.school.godbless.sprint5.collectOrders.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private static int countId = 0;
    private int id;
    private Status status;

    public Order(){
        this.status = Status.NEW;
        this.id = countId++;
    }
}

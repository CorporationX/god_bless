package faang.school.godbless.sprint5.multithreading_async.task10_amazon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private int id;

    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "Не обработано";
    }
}
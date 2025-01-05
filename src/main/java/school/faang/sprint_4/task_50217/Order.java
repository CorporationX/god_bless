package school.faang.sprint_4.task_50217;

import lombok.Getter;

@Getter
public class Order {
    private int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        this.status = OrderStatus.NEW;
    }

    public void changeStatus() {
        if (status == OrderStatus.NEW) {
            status = OrderStatus.PROCESSED;
        } else {
            System.out.println("Заказ " + id + " уже обработан");
        }
    }
}

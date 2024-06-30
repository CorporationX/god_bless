package faang.school.godbless.multithreading_2.amazon;

import lombok.Setter;



public class Order {
    private int id;
    @Setter
    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "Создан";
    }
}

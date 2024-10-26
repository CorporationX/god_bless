package school.faang.ordersamazon;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private final int id;
    @Setter
    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "Не обработано";
    }
}

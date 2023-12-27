package faang.school.godbless.multi_asyn.task7amazon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    private String status = "Необработано";

    public Order(int id) {
        this.id = id;
    }
}

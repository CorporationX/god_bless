package school.faang.collectamazon;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private static int id = 0;
    @NonNull
    private String status;

    public Order(String status) {
        this.status = status;
        id++;
    }
}

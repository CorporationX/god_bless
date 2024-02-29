package faang.school.godbless.collectingamazonorders3165;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Order {
    private int id;
    @Setter private String status;
    private static int counter;

    public Order() {
        this.id = ++counter;
        this.status = "Processing";
    }
}

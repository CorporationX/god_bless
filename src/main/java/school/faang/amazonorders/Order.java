package school.faang.amazonorders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private static int currentId = 1;

    private final int id = currentId++;
    private String status = "In progress";
}

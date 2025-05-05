package school.faang.stream4.amazonorders;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Order {
    private final int id;
    @Setter private String status;
}

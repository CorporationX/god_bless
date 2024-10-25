package school.faang.processing_amazon_orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private final int id;
    private Status status;
}
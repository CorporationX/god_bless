package school.faang.Multithreading.sprint_4.Amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private int id;
    private OrderStatus status;
}



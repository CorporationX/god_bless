package school.faang.Sprints.Multithreading_Async.collect_orders_from_amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Order {
    private int id;
    private String status;
}

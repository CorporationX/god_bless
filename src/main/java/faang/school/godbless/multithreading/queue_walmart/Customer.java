package faang.school.godbless.multithreading.queue_walmart;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class Customer {
    private int customerId;
    private List<Item> items;
}

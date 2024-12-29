package school.faang.sprint_4.task_bjs250382;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class TestDataGenerator {
    public static int startOrderNumber = 1;

    public List<Order> getTestOrders(int capacity) {
        return IntStream.range(0, capacity)
                .mapToObj(i -> getTestOrder())
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

    public Order getTestOrder() {
        return new Order(startOrderNumber++, OrderType.NEW);
    }
}

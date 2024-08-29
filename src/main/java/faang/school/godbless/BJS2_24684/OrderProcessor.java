package faang.school.godbless.BJS2_24684;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
}

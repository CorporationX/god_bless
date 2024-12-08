package school.faang.bjs245148;

import lombok.*;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Product {
    private static final AtomicInteger incrementId = new AtomicInteger(1);
    private final int id = incrementId.getAndIncrement();
    private final String name;
    private final String category;
}

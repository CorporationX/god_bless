package school.faang.bjs2_68950;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(1);

    private final int id;
    private final String name;
    private final Category category;

    public Product(Category category, String name) {
        this.id = createId();
        this.category = category;
        this.name = name;
    }

    public static Integer createId() {
        return ID_COUNTER.getAndIncrement();
    }
}

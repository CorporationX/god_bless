package school.faang.task_45105;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Product {
    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.id = idCounter.getAndIncrement();

        if (StringUtils.isBlank(name) || StringUtils.isBlank(category)) {
            throw new IllegalArgumentException("Invalid params");
        }
        this.name = name;
        this.category = category;
    }
}

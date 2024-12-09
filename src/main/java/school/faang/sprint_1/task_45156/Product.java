package school.faang.sprint_1.task_45156;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@ToString
public class Product {
    //private static int count = 0;
    private static AtomicInteger count = new AtomicInteger(1);

    private final int id;
    private final String name;
    @Getter
    private final String category;

    public Product(String name, String category) {
        //id = ++count;
        id = count.getAndIncrement();
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}

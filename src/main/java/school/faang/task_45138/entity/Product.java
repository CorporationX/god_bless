package school.faang.task_45138.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Product {
    private static AtomicInteger idCounter = new AtomicInteger(1);
    private int id;
    private String name;
    private String category;

    public Product( String name, String category) {
        this.id = idCounter.getAndIncrement();
        if(name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        if(category.isBlank()){
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        this.category = category;
    }
}

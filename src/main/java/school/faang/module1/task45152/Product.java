package school.faang.module1.task45152;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@ToString
@EqualsAndHashCode
@Getter
public class Product {

    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String category;

    public Product(String name, String category) {
        Random randomInt = new Random();
        this.id = randomInt.nextInt();
        this.name = name;
        this.category = category;
    }

}

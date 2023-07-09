package faang.school.godbless.sprint5.multithreading_conc.task11_coupons;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@ToString
public class Product {

    private String name;

    private int price;

    private static int counter = 0;

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public Product() {
        this.name = "Product " + counter++;
        this.price = random.nextInt(10, 40);
    }
}

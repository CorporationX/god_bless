package faang.school.godbless.Maps.BJS2_19505;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@ToString
@EqualsAndHashCode
@Getter
public class Product {
    private final int id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.id = ThreadLocalRandom.current().nextInt(1,10000);
        this.name = name;
        this.category = category;

    }
}

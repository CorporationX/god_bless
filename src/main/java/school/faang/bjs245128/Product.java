package school.faang.bjs245128;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    @Getter
    private String category;

    public static Product create(String category, String name) {
        Random random = new Random();
        return new Product(random.nextLong(), name, category);
    }

}

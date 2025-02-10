package school.faang.amazonestorage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    private final int id;
    private final String name;
    private final Category category;
}

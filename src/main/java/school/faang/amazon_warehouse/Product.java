package school.faang.amazon_warehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Product {
    private final Integer id;
    private final String name;
    private final Category category;
}

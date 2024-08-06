package amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Product {
    private final Integer id;
    private final String name;
    private final String category;
}

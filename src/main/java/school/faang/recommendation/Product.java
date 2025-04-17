package school.faang.recommendation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private final int productId;
    private final String name;
    private final String category;
    private final Double price;
    private final List<String> tags;
}

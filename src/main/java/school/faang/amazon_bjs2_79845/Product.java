package school.faang.amazon_bjs2_79845;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private Category category;
}

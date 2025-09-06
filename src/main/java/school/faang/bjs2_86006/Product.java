package school.faang.bjs2_86006;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private Category category;
}

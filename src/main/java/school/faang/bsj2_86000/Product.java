package school.faang.bsj2_86000;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private final int id;
    private final String name;
    private final Category category;
}

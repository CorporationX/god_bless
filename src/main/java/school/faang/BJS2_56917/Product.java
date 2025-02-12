package school.faang.BJS2_56917;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(exclude = "id")
public class Product {
    private final int id;
    private final String name;
    private final Category category;
}

package school.faang.sprint_1.task_bjs245200;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private final UUID id;
    @EqualsAndHashCode.Exclude
    private final String name;
    @EqualsAndHashCode.Exclude
    private final ProductCategory category;

    public Product(String name, ProductCategory category) {
        NameValidator.validateCategoryAndName(category, name);
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
    }
}

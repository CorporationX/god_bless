package school.faang.sprint_1.task_bjs245200;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@EqualsAndHashCode
@ToString
public class Product {
    @EqualsAndHashCode.Exclude
    private final UUID id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        NameValidator.validateName(name, category);
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
    }
}

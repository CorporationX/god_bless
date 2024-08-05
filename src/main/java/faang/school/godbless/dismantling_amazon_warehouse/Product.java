package faang.school.godbless.dismantling_amazon_warehouse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
public class Product {
    private UUID id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
    }
}

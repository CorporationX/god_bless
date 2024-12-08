package school.faang.bjs245160;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product {
    @EqualsAndHashCode.Exclude
    private final UUID id;
    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
    }
}

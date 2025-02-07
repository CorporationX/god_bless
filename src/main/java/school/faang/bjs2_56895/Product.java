package school.faang.bjs2_56895;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private Category category;
}

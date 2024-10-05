package school.faang.task138;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private String category;
}

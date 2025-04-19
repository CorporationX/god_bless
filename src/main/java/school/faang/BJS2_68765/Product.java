package school.faang.BJS2_68765;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private Category category;
}

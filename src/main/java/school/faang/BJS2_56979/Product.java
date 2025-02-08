package school.faang.BJS2_56979;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Product {
    private int id;
    private String name;
    private Category category;
}

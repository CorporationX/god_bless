package school.faang.bjs269869;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Product {

    private int id;
    private String name;
    private Category category;
}

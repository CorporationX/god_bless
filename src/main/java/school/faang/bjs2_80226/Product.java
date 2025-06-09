package school.faang.bjs2_80226;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Product {
    private int id;
    private String name;
    private CategoryEnum category;
}

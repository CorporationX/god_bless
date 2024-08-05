package faang.school.godbless.warehouse_amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    private int id;
    private String name;
    private String category;
}

package school.faang.bjs2_79821;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private Category category;
}

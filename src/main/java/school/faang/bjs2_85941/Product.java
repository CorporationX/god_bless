package school.faang.bjs2_85941;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Product {
    private int id;
    private String name;
    private Category category;
}

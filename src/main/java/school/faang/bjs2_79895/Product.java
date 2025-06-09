package school.faang.bjs2_79895;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private Category category;
}

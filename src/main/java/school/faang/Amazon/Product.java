package school.faang.Amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private String category;
}

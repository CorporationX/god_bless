package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String category;
}

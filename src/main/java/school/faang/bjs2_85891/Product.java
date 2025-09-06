package school.faang.bjs2_85891;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    private int id; // (уникальный идентификатор);
    private String name;
    private Category category;
}

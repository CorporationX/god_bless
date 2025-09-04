package school.faang.bjs2_85891;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private int id; // (уникальный идентификатор);
    private String name;
    private Category category;

    public enum Category {
        FOOD, ELECTRONICS, CLOTHING, OTHER
    }
}

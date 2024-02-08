package faang.school.godbless.AmazonStorage2040;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Product {
    private int id;
    private String category;
    private String name;


    public Product(int id, String category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }
}

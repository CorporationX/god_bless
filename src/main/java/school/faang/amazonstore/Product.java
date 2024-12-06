package school.faang.amazonstore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    protected int id;
    protected String name;
    protected String category;
}

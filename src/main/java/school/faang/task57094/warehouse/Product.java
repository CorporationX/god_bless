package school.faang.task57094.warehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    private int id;
    private String name;
    private Category category;
}

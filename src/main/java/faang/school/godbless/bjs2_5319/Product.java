package faang.school.godbless.bjs2_5319;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private List<String> tags;
}

package school.faang.sprint_2.task_47968;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Product {
    private int productId;
    private String name;
    private String category;
    private float price;
    private List<String> tags;
}

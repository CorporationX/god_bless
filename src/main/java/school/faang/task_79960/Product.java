package school.faang.task_79960;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Product {
    private int id;
    private String name;
    private Category category;

}

package school.faang.task_45086;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Product {
    private final int id;
    private final String name;
    private final Category category;
}
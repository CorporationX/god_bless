package school.faang.task_56988;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    @EqualsAndHashCode.Exclude
    private final int id;
    private final String name;
    private final Category category;
}

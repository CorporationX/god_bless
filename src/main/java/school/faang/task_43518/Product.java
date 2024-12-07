package school.faang.task_43518;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Product {
    @EqualsAndHashCode.Exclude
    private final long id;
    private final String name;
    @ToString.Exclude
    private final String category;
}

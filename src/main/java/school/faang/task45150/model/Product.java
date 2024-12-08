package school.faang.task45150.model;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Product {
    private final Integer id;
    private final String category;
    private final String name;
}

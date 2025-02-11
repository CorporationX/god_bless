package school.faang.sprint1.task_56945;

import java.util.UUID;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    private final UUID id;
    private final String name;
    private Category category;
}

package school.faang.sprint1task45166;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    int id;
    String name;
    String category;
}
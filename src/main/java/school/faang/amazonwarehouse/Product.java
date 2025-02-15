package school.faang.amazonwarehouse;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    private final int id;
    @NonNull private final String name;
    @NonNull private final Category category;
}

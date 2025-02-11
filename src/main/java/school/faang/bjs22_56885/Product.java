package school.faang.bjs22_56885;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    @EqualsAndHashCode.Exclude
    private final int id;
    @NonNull
    private final String name;
    @NonNull
    private final Category category;
}

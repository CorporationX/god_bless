package school.faang.BJS2_85982;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = true)
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    @EqualsAndHashCode.Exclude
    private final int id;
    @Getter
    private final String name;
    @Getter
    private final Category category;
}

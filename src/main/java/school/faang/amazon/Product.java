package school.faang.amazon;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Locale;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    private final int id;
    private final String name;
    private Category category;
}

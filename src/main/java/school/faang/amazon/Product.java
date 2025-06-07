package school.faang.amazon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"name", "category"})
public class Product {

    private final Integer id;
    private final String name;
    private final Category category;
}

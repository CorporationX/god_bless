package faang.school.godbless.alexbulgakoff.javahashmap.amazonewarehouse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Product {

    private Integer id;

    private String name;

    private Category category;
}

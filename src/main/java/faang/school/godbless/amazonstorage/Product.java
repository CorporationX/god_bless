package faang.school.godbless.amazonstorage;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Product {

    private long id;
    private String name;
    private String category;
}

package faang.school.godbless.BJS2_19319;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {

    private final int id;
    private final String name;
    @Getter
    private final String category;

}

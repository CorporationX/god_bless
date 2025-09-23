package school.faang.sprint1.amazonwarehouse;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Product {

    private final int id;
    private final String name;
    private final Category category;

}

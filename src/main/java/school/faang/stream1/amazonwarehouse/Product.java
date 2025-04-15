package school.faang.stream1.amazonwarehouse;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Product {
    private final int id;
    private final String name;
    private final Category category;
}

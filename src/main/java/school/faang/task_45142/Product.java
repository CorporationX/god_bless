package school.faang.task_45142;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Product {
    private final int id;
    private final String name;
    private final String category;

}

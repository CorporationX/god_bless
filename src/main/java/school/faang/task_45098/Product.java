package school.faang.task_45098;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {
    private final String id;
    @Getter
    private final String name;
    @Getter
    private final String category;
}

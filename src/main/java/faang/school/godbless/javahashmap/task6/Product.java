package faang.school.godbless.javahashmap.task6;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Product {
    private Integer id;
    private String name;
    private String category;
}

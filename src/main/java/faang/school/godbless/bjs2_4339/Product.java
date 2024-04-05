package faang.school.godbless.bjs2_4339;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = "category")
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String category;
}

package school.faang.bjs245128;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    @Getter
    private String category;

}

package school.faang.bjs2_68689;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Product {
    private long id;
    private String name;
    private Category category;
}

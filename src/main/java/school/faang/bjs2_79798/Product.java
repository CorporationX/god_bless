package school.faang.bjs2_79798;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    private final Long id;
    private final String name;
    private final Category category;


}

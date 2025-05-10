package school.faang.bjs2_75964;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(exclude = {"price"})
public class Product {
    private final String name;
    @Setter
    private double price;
}

package faang.school.godbless.sprint2.uberEats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.StringJoiner;

/**
 * @author Evgenii Malkov
 */
@Getter
@AllArgsConstructor
public class Product {
    private String name;
    @Setter
    private double price;

    @Override
    public String toString() {
        return new StringJoiner(", ")
                .add(name)
                .toString();
    }
}

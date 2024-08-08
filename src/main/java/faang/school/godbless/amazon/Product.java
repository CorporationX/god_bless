package faang.school.godbless.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private final int ID;
    private String name;
    private String category;

    @Override
    public String toString() {
        return name;
    }
}

package school.faang.bjs_48570;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Food {
    private final String name;

    public Food(String name) {
        this.name = name;
    }
}

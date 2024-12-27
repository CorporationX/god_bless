package school.faang.bjs248526;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Food {
    private final String name;

    @Override
    public String toString() {
        return "Food{name='" + name + "'}";
    }
}

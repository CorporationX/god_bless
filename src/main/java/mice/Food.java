package mice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Food {
    private final String foodName;

    @Override
    public String toString() {
        return foodName;
    }
}

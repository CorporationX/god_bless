package mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Food {
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}

package school.faang.miceareverynice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Food {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}

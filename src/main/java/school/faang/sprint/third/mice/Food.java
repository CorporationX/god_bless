package school.faang.sprint.third.mice;

import lombok.Data;
import lombok.NonNull;

@Data
public class Food {
    @NonNull
    private final String name;

    public Food(@NonNull String name) {
        validateFoodName(name);
        this.name = name;
    }

    private void validateFoodName(@NonNull String name) {
        if (name == null) {
            throw new NullPointerException("name is null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("name is blank");
        }
    }
}

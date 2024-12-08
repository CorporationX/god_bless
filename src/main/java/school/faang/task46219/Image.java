package school.faang.task46219;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Image {
    private final String name;
    private final String description;

    public Image(String name, String description) {
        validate(name, description);

        this.name = name;
        this.description = description;
    }

    private void validate(String name, String description) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
    }
}

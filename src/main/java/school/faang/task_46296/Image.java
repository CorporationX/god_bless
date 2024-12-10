package school.faang.task_46296;

import lombok.Getter;

@Getter
public class Image {
    private final String name;
    private final String description;

    public Image(String name, String description) {
        validName(name);
        validDescription(description);

        this.name = name;
        this.description = description;
    }

    private static void validDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description don't be null or blank!");
        }
    }

    private static void validName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name don't be null or blank!");
        }
    }
}

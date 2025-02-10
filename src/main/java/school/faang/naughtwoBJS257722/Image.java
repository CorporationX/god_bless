package school.faang.naughtwoBJS257722;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Image {
    private final String name;
    private final String description;

    public Image(String name, String description) {
        checkImage(name, description);
        this.name = name;
        this.description = description;
    }

    private void checkImage(String name, String description) {
        try {
            if (name == null || name.isBlank() || description == null) {
                throw new IllegalArgumentException("Name or Description is 'null'.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument " + e.getMessage());
        }
    }
}

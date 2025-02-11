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
        if (name == null || name.isBlank()
                || description == null || description.isBlank()) {
            IllegalArgumentException e = new  IllegalArgumentException("Name or Description is 'null'.");
            System.out.println("Illegal Argument " + e.getMessage());
        }
    }
}

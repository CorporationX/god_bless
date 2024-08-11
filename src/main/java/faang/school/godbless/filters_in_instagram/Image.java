package faang.school.godbless.filters_in_instagram;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.name = name;
        this.description = description;
    }
}

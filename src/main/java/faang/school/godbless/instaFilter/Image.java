package faang.school.godbless.instaFilter;

import lombok.Getter;

@Getter
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("incorrect data for object initialization");
        }
        this.name = name;
        this.description = (description != null) ? description : "";
    }
}

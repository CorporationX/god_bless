package school.faang.BJS2_34837_InstagramFilters;

import lombok.Getter;

@Getter
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        validateString(name, "Invalid image name!");
        validateString(description, "Invalid image description!");
        this.name = name;
        this.description = description;
    }

    private void validateString(String info, String message) {
        if (info == null || info.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}

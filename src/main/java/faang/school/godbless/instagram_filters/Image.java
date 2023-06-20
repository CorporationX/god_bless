package faang.school.godbless.instagram_filters;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Image {

    private String name;
    private String description;

    public Image(String name, String description) {
        validateInput(name, "File name");
        validateInput(description, "Description");
        this.name = name;
        this.description = description;
    }

    private void validateInput(String input, String inputType) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(inputType + " can't be empty");
        }
    }
}

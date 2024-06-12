package faang.school.godbless.lambdas.instagram;

import lombok.Data;

@Data
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name can`t be empty");
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new IllegalArgumentException("Description can`t be empty");
        }
        this.name = name;
        this.description = description;
    }
}

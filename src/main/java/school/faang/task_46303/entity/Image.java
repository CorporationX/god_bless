package school.faang.task_46303.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Image name and description cannot be empty");
        }
        this.name = name;
        this.description = description;
    }
}

package school.faang.task_46325;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name не может быть пустым");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description не может быть пустым");
        }
        this.name = name;
        this.description = description;
    }
}

package school.faang.task_57622;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private String name;
    private String description;

    public Image(String description, String name) {
        this.description = description;
        this.name = name;
    }
}

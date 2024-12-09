package school.faang.sprint_2.task_46256;

import lombok.Getter;

@Getter
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
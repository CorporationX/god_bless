package school.faang.sprint2.task_46473;

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
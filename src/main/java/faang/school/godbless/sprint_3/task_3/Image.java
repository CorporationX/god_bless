package faang.school.godbless.sprint_3.task_3;

import lombok.Data;

@Data
public class Image {
    private String name;
    private String descriptionFile;

    public Image(String name, String descriptionFile) {
        this.name = name;
        this.descriptionFile = descriptionFile;
    }
}

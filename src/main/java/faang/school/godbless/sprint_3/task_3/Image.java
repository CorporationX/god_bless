package faang.school.godbless.sprint_3.task_3;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Image {
    String name;
    String descriptionFile;

    public Image(String name, String descriptionFile) {
        this.name = name;
        this.descriptionFile = descriptionFile;
    }
}

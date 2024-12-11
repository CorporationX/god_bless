package school.faang.task_46356;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private String name;
    private String description;


    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }

}

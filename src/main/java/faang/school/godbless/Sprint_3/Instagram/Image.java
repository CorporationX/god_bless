package faang.school.godbless.Sprint_3.Instagram;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

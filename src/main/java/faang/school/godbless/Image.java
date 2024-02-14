package faang.school.godbless;

import lombok.Getter;

@Getter
public class Image {
    String fileName;
    String description;

    public Image(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
    }
}

package faang.school.godbless.instagram;

import lombok.Getter;

@Getter
public class Image {
    private String name;
    private String description;

    public Image(String fileName, String description) {
        this.name = fileName;
        this.description = description;
    }
}
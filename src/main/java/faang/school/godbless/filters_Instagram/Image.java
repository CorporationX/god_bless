package faang.school.godbless.filters_Instagram;

import lombok.Data;

@Data
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

package faang.school.godbless.image;

import lombok.Getter;

@Getter
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Image{name='" + name + "', description='" + description + "'}";
    }
}

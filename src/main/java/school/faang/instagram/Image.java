package school.faang.instagram;

import lombok.Getter;

@Getter
class Image {
    private final String name;
    private final String description;

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
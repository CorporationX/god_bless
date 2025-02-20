package school.faang.instagram;

import lombok.Getter;

@Getter
class Image {
    @Getter
    private static String name;
    @Getter
    private static String description;

    public Image(String name, String description) {
        Image.name = name;
        Image.description = description;
    }
}
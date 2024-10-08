package instagram.filters;

import lombok.Getter;

@Getter
public class Image {
    private final String name;
    private final String description;

    public Image(String name, String description) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя файла изображения не должно быть пустым");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Описание не может быть пустым");
        }

        this.name = name;
        this.description = description;
    }
}

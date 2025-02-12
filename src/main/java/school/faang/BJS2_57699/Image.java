package school.faang.BJS2_57699;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class Image {

    private final String name;
    private String description;

    public Image(@NonNull String name, String description) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
        this.description = description;
    }
}

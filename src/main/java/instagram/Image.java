package instagram;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Image {
    private final String name;
    private final String description;

    public Image(String name, String description) {
        this.name = Objects.requireNonNull(name, "Image name cannot be null");
        this.description = Objects.requireNonNull(description, "Image description cannot be null");
    }
}

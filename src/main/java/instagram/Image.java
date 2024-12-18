package instagram;

import lombok.Getter;
import lombok.Setter;

@Setter
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

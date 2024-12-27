package filters_Instagram;

import lombok.Data;

@Data
public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        this.description = description;
        this.name = name;
    }
}
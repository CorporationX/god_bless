package filter_Instagram;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Image {
    String fileName;
    String description;

    public Image(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
    }
}

package school.faang.bjs2_87794;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Image {
    private final String fileName;
    private String description;

    public Image(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
    }
}

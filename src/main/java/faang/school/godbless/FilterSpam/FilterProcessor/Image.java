package faang.school.godbless.FilterSpam.FilterProcessor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private String fileName;
    private String description;

    public Image(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
    }
}
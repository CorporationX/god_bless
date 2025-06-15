package school.faang.bjs2_80571;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Image {
    private String name;
    private String description;

    public Image withDescription(String newDescription) {
        return new Image(this.name, newDescription);
    }
}

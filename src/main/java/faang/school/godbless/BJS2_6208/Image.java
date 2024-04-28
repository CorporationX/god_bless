package faang.school.godbless.BJS2_6208;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Image {
    private String name;
    private String description;

    @Override
    public String toString() {
        return String.format("File name: %s | Description: %s", this.name, this.description);
    }
}

package school.faang.task_46500;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Image {

    private final String name;
    private final String description;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Image{");
        stringBuilder.append("name='");
        stringBuilder.append(name);
        stringBuilder.append('\'');
        stringBuilder.append(", description='");
        stringBuilder.append(description);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

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
        StringBuilder builder = new StringBuilder();
        builder.append("Image{");
        builder.append("name='");
        builder.append(name);
        builder.append('\'');
        builder.append(", description='");
        builder.append(description);
        builder.append('\'');
        builder.append('}');
        return builder.toString();
    }
}

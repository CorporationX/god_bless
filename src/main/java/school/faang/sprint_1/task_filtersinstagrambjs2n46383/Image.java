package school.faang.sprint_1.task_filtersinstagrambjs2n46383;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Image {
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Image{"
                + "name='" + name + '\''
                + ", description='" + description + '\''
                + '}';
    }
}

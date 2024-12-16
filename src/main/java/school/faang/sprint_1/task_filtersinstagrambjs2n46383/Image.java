package school.faang.sprint_1.task_filtersinstagrambjs2n46383;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Image {
    private String name;
    private String description;

    public Image(@NonNull String name, @NonNull String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Image{"
                + "name='" + name + '\''
                + ", description='" + description + '\''
                + '}';
    }
}

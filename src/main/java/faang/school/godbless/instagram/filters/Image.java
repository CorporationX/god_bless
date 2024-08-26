package faang.school.godbless.instagram.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Image {
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Image{" +
                "fileName='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

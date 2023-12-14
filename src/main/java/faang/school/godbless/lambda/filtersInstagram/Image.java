package faang.school.godbless.lambda.filtersInstagram;

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
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

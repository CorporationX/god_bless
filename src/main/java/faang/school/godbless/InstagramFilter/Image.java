package faang.school.godbless.InstagramFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Filename - " + name + ". Description - " + description;
    }
}

package school.faang.instagram;

import lombok.Data;

@Data
public class Image {
    private final String name;
    private final String description;
    FilterProcessor filterProcessor = new FilterProcessor();

    public Image(String name, String description) {
        this.name = name;
        this.description = description;

        filterProcessor.checkArguments(name, description);
    }
}
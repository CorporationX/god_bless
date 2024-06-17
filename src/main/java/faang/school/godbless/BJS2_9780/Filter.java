package faang.school.godbless.BJS2_9780;

import lombok.Getter;

import java.util.function.Function;

@Getter
public class Filter {
    private final String suffix;
    private final String description;
    Function<Image, Image> filter;

    public Filter(String suffix, String description) {
        this.suffix = suffix;
        this.description = description;
        this.filter = img -> new Image(img.getFileName() + suffix, description);
    }
}

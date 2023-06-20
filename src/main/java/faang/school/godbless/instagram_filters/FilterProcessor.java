package faang.school.godbless.instagram_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

@AllArgsConstructor
@Getter
class Image {
    private String name;
    private String description;
}

package school.faang.task_46393;

import java.util.Optional;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(Optional.ofNullable(image)
                .orElseThrow(() ->
                        new IllegalArgumentException("Image cannot be null")));
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

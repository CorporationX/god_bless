package school.faang.sprint2.task_3;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Image cannot be null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Filter cannot be null");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        if (filter1 == null) {
            throw new IllegalArgumentException("Filter 1 cannot be null");
        }
        if (filter2 == null) {
            throw new IllegalArgumentException("Filter 2 cannot be null");
        }
        return filter1.andThen(filter2);
    }
}

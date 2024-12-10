package school.faang.sprint_2.task_46256;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null || filter == null) {
            throw new NullPointerException("Image or Filter must not be null");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        if (filter1 == null || filter2 == null) {
            throw new NullPointerException("Filter must not be null");
        }
        return filter1.andThen(filter2);
    }
}
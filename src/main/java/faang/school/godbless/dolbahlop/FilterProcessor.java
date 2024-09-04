package faang.school.godbless.dolbahlop;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return image -> {
            Image firstResult = firstFilter.apply(image);
            return secondFilter.apply(firstResult);
        };
    }
}

package faang.school.godbless.instaFilter;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        if (image == null) {
            throw new IllegalArgumentException("Image is null");
        }
        if (function == null) {
            throw new IllegalArgumentException("Function is null");
        }
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}

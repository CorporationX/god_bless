package school.faang.filtersofinstagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Image is incorrect");
        } else if (filter == null) {
            throw new IllegalArgumentException("Filter is incorrect");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        if (firstFilter == null || secondFilter == null) {
            throw new IllegalArgumentException("One of the filters is incorrect");
        }
        return firstFilter.andThen(secondFilter);
    }
}

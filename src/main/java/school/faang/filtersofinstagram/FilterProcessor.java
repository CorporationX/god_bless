package school.faang.filtersofinstagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new NullPointerException("Image is null");
        } else if (filter == null) {
            throw new NullPointerException("Filter is null");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        if (firstFilter == null || secondFilter == null) {
            throw new NullPointerException("One of the filters is null");
        }
        return firstFilter.andThen(secondFilter);
    }
}

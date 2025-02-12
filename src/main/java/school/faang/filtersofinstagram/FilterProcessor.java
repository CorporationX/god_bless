package school.faang.filtersofinstagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Invalid value image");
        } else if (filter == null) {
            throw new IllegalArgumentException("Invalid value filter");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        if (firstFilter == null || secondFilter == null) {
            throw new IllegalArgumentException("Invalid value one of the filters");
        }
        return firstFilter.andThen(secondFilter);
    }
}

package school.faang.instafilteres;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Image is required");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Filter is required");
        }

        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> firstFilter,
            Function<Image, Image> secondFilter
    ) {
        if (firstFilter == null || secondFilter == null) {
            throw new IllegalArgumentException("Both filters are required");
        }

        return firstFilter.andThen(secondFilter);
    }
}

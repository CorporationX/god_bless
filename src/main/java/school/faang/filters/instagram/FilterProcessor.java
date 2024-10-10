package school.faang.filters.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public static Image combineFilters(Image image, Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2).apply(image);
    }
}

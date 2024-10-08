package filtersInstagram;

import java.util.function.Function;

public class FilterProcessor {

    Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}

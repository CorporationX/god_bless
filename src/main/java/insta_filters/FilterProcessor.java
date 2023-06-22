package insta_filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilter(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}

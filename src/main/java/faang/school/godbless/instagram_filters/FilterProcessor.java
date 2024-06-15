package faang.school.godbless.instagram_filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image originalImage, Function<Image, Image> filter) {
        return filter.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}
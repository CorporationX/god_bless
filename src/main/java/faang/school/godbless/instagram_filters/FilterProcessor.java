package faang.school.godbless.instagram_filters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> useFilter) {
        return useFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}

package faang.school.godbless.BJS2_5270;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageAfterFilter) {
        return imageAfterFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}

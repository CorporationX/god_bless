package faang.school.godbless.BJS2_9821;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image sourceImage, Function<Image, Image> filterFunction) {
        return filterFunction.apply(sourceImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}

package faang.school.godbless.filtersInstagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> applyFilter) {
        return applyFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFunction, Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }
}

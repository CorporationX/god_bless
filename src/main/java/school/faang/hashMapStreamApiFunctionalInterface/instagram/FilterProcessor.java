package school.faang.hashMapStreamApiFunctionalInterface.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter, Function<Image, Image> anotherFilter) {
        return filter.andThen(anotherFilter);
    }
}

package school.faang.filters.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public static Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public static Image combineFilters(Image image, Function<Image, Image> function1, Function<Image, Image> function2) {
        return function1.andThen(function2).apply(image);
    }
}

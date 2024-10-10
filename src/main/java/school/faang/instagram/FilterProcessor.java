package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return function1.compose(function2);
    }
}
package faang.school.godbless.instagram_filters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        if (function1 == null || function2 == null) {
            throw new RuntimeException("Filters should not be null");
        }
        return function1.andThen(function2);
    }
}
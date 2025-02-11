package school.faang.instagramfilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image originalImage, Function<Image, Image> function) {
        if (originalImage == null) {
            throw new IllegalArgumentException("Image cannot be null");
        }
        if (function == null) {
            throw new IllegalArgumentException("Filter cannot be null");
        }
        return function.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> function1, Function<Image, Image> function2) {
        if (function1 == null || function2 == null) {
            throw new IllegalArgumentException("Filter cannot be null");
        }
        return function1.andThen(function2);
    }
}
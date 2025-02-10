package school.faang.instagramfilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image originalImage, Function<Image, Image> function) {
        return function.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> function1, Function<Image, Image> function2) {
        return function1.andThen(function2);
    }
}

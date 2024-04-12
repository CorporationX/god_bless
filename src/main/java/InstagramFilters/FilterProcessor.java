package InstagramFilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        if (image == null || function == null) {
            throw new RuntimeException("Image or function is null.");
        }
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        if (function1 == null || function2 == null) {
            throw new RuntimeException("Function1 or function2 is null.");
        }
        return function1.andThen(function2);
    }
}

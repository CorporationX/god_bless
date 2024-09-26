package task7;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function, Function<Image, Image> function1) {
        return (image) -> function1.apply(function.apply(image));
    }
}
package instagram.filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filterFunction) {
        return filterFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFunction, Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }
}

package instagram.filter;

import java.util.function.Function;

public class FilterProcessor {


    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function, Function<Image, Image> function2) {
        return function.andThen(function2);
    }
}

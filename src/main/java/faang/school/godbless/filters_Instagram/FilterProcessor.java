package faang.school.godbless.filters_Instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> something) {
        return something.apply(image);

    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function, Function<Image, Image> function1) {
        Function<Image, Image> func = function.andThen(function1);
        return func;
    }
}

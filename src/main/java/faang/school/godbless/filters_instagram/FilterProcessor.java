package faang.school.godbless.filters_instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> func) {
        return func.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> func1, Function<Image, Image> func2) {
        return func1.andThen(func2);
    }
}
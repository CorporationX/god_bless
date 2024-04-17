package faang.school.godbless.sprint2.BJS2_5396;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFunction, Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }
}

package school.faang.BJS2_59840;

import java.util.function.Function;

public class FilterProcessor {
    Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    Function<Image, Image> combineFilters(Function<Image, Image> a, Function<Image, Image> b) {
        return a.andThen(b);
    }
}
package school.faang.bjs2_91919;

import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public static Function<Image, Image> combineFilters(
            Function<Image, Image> function1, Function<Image, Image> function2,
            Function<Image, Image> function3) {
        return function1.andThen(function2).andThen(function3);
    }
}



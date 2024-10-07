package school.faang.task213.Filter;

import school.faang.task213.image.Image;

import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> firstFunction,
                                                        Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }
}

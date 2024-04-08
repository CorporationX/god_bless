package faang.school.godbless.InstagramFilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        if (image == null || function == null) {
            return null;
        }
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFunction, Function<Image, Image> secondFunction) {
        if (firstFunction == null || secondFunction == null) {
            return null;
        }
        return firstFunction.andThen(secondFunction);
    }
}

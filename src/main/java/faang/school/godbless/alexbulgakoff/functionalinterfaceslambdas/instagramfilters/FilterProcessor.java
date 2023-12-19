package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.instagramfilters;

import java.util.function.Function;

/**
 * @author Alexander Bulgakov
 */

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFunction,
                               Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }
}

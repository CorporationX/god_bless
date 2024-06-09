package faang.school.godbless.filtersInstagram;

import java.util.function.Function;

public class FilterProcessor {

    Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return function2.andThen(function1);
    }

}

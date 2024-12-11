package school.faang.task_46264;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterA, Function<Image, Image> filterB) {
        return filterB.compose(filterA);
    }
}
package school.faang.task_46557;

import java.util.function.Function;

public class FilterProcessor {

    Image applyFilter(Image oldImage, Function<Image, Image> filter) {
        return filter.apply(oldImage);
    }

    Function combineFilter(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        return filterOne.andThen(filterTwo);
    }
}

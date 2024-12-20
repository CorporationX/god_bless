package school.faang.task_46576;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image img, Function<Image, Image> filter) {
        return filter.apply(img);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image,
            Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }

}

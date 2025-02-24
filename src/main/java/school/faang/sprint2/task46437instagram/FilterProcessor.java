package school.faang.sprint2.task46437instagram;

import java.util.function.Function;

public class FilterProcessor {
    Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    Function<Image, Image> combineFilters(Function<Image, Image> filterFirst, Function<Image, Image> filterSecond) {
        return filterFirst.andThen(filterSecond);
    }
}

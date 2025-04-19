package school.faang.BJS2_70601;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                                  Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}

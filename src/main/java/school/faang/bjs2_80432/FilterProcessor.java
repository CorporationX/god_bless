package school.faang.bjs2_80432;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterFirst,
                                                 Function<Image, Image> filterSecond) {
        Function<Image, Image> combinedFilter = image -> filterFirst.andThen(filterSecond).apply(image);
        return combinedFilter;
    }
}

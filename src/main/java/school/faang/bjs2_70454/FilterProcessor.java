package school.faang.bjs2_70454;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Function<Image, Image> filter, Image image) {
        return filter.apply(image);
    }

    public Image combineFilter(Function<Image, Image> filter1, Function<Image, Image> filter2, Image image) {
        Function<Image, Image> combinedFilter = filter1.andThen(filter2);
        return combinedFilter.apply(image);
    }
}

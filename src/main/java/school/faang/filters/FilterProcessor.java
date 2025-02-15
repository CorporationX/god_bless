package school.faang.filters;

import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return image -> filter2.apply(filter1.apply(image));
    }
}

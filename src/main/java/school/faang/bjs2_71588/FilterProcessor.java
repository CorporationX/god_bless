package school.faang.bjs2_71588;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> firstFilter,
            Function<Image, Image> secondFilter) {
        return image -> secondFilter.apply(firstFilter.apply(image));
    }
}

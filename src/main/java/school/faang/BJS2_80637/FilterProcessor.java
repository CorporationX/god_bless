package school.faang.BJS2_80637;

import java.util.function.Function;

public class FilterProcessor {
    Image applyFilter(Image originalImage, Function<Image, Image> filter) {
        return filter.apply(originalImage);
    }

    Function<Image, Image> combineFilters(
            Function<Image, Image> firstFilter,
            Function<Image, Image> secondFilter) {
        return image -> secondFilter.apply(firstFilter.apply(image));
    }
}

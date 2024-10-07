package school.faang.instagramfilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filterFunction) {
        return filterFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return (image) -> {
            Image processedFirst = firstFilter.apply(image);
            return secondFilter.apply(processedFirst);
        };
    }
}

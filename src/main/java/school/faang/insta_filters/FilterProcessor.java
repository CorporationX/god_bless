package school.faang.insta_filters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> imageFilter) {
        return imageFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> preFilter, Function<Image, Image> filter) {
        return preFilter.andThen(filter);
    }
}

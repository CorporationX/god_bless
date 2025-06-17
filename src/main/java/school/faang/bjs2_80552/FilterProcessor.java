package school.faang.bjs2_80552;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> mainFilter,
            Function<Image, Image> additionalFilter) {
        return (image) -> {
            image = mainFilter.apply(image);
            image = additionalFilter.apply(image);
            return image;
        };
    }
}

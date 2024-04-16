package faang.school.godbless.filtersinstagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return (image) -> {
            Image imageAfterFilter1 = filter1.apply(image);
            return filter2.apply(imageAfterFilter1);
        };
    }
}

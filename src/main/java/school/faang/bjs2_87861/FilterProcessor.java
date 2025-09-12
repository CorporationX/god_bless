package school.faang.bjs2_87861;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter, Function<Image, Image> filter1) {
        return filter.andThen(filter1);
    }
}

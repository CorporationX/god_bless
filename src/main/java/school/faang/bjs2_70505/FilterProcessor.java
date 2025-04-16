package school.faang.bjs2_70505;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        return filterOne.andThen(filterTwo);
    }
}

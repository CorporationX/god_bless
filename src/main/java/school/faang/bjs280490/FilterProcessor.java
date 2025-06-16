package school.faang.bjs280490;

import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public static Function<Image, Image>
        combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        return filterOne.andThen(filterTwo);
    }
}

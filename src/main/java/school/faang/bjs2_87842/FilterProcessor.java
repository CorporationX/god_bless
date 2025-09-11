package school.faang.bjs2_87842;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image img, Function<Image, Image> filter) {
        return filter.apply(img);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        return filterOne.andThen(filterTwo);
    }
}

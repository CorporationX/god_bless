package faang.school.godbless.lambdas3;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image img, Function<Image, Image> filters) {
        return filters.apply(img);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        return filterOne.andThen(filterTwo);
    }
}
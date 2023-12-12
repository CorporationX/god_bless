package faang.school.godbless.filtersInstagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> func) {
        return func.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne,
                                                 Function<Image, Image> filterTwo) {
        return filterOne.andThen(filterTwo);
    }
}

package faang.school.godbless.Instagram.filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return function2.compose(function1);
    }
}

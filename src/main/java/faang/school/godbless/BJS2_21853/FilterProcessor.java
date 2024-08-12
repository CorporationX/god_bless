package faang.school.godbless.BJS2_21853;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> func1, Function<Image, Image> func2) {
        return func1.andThen(func2);
    }
}

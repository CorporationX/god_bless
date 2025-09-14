package school.faang.bjs2_87890;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> before, Function<Image, Image> after) {
        return before.andThen(after);
    }
}

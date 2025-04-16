package school.faang.bjs2_70454;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Function<Image, Image> filter, Image image) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilter(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

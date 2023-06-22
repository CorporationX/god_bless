package faang.school.godbless.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2, Function<Image, Image> filter3) {
        return filter1.andThen(filter2).andThen(filter3);
    }
}

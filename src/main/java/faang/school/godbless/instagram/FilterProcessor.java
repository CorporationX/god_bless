package faang.school.godbless.instagram;

import java.util.function.Function;

public class FilterProcessor {
    Image applyFilter(Image originalImage, Function<Image, Image> filter) {
        return filter.apply(originalImage);
    }

    Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.compose(filter2);
    }
}

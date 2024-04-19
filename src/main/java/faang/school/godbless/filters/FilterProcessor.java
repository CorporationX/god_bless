package faang.school.godbless.filters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> imageFilter) {
        return imageFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> imageFilter1, Function<Image, Image> imageFilter2) {
        return imageFilter1.compose(imageFilter2);
    }
}

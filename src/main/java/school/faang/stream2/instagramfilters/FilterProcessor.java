package school.faang.stream2.instagramfilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageFilter) {
        return imageFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return image -> function2.apply(function1.apply(image));
    }
}

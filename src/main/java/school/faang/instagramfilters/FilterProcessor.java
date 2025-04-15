package school.faang.instagramfilters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null || filter == null) {
            throw new IllegalArgumentException("Image and consumer must not be null!");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

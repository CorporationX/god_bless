package school.faang.task46219;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> imageFilter) {
        if (image == null) {
            throw new IllegalArgumentException("image is null");
        }
        if (imageFilter == null) {
            throw new IllegalArgumentException("Filter is null");
        }

        return imageFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        if (filter1 == null || filter2 == null) {
            throw new IllegalArgumentException("filter is null");
        }

        return filter1.andThen(filter2);
    }
}

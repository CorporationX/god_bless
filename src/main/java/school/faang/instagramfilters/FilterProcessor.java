package school.faang.instagramfilters;

import java.util.function.Function;

public class FilterProcessor {

    // Method to apply a filter to an image
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    // Method to combine two filters into one
    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

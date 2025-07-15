package school.faang.module1.bjs2_80463;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> imageFilter) {
        if (image == null) {
            throw new IllegalArgumentException("Image cannot be null");
        }
        if (imageFilter == null) {
            throw new IllegalArgumentException("Image filter function cannot be null");
        }
        return imageFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterFirst,
                                                 Function<Image, Image> filterSecond) {
        if (filterFirst == null) {
            throw new IllegalArgumentException("First filter cannot be null");
        }
        if (filterSecond == null) {
            throw new IllegalArgumentException("Second filter cannot be null");
        }
        return filterFirst.andThen(filterSecond);
    }
}
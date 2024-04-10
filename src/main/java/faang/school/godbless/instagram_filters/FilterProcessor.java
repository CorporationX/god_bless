package faang.school.godbless.instagram_filters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filterImage) {
        if (image == null) {
            throw new NullPointerException("The image field is missing");
        }
        return filterImage.apply(image);
    }

    public <T> Function<T, T> combineFilters(Function<T, T> firstFilter, Function<T, T> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}


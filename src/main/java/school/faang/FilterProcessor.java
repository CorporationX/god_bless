package school.faang;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        validateImage(image);
        validateFilter(filter);
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        validateFilter(firstFilter);
        validateFilter(secondFilter);
        return firstFilter.andThen(secondFilter);
    }

    private void validateImage(Image image) {
        if (image == null) {
            throw new IllegalArgumentException("The image can't be null or blank");
        }
    }

    private void validateFilter(Function<Image, Image> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("The filter can't be null or blank");
        }
    }
}

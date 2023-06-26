package faang.school.godbless.igFilters;

import java.util.function.Function;

public class FilterProcessor {
    private static final String ERROR_IMAGE_NULL = "The image can't be blank";
    private static final String ERROR_FILTER_NULL = "The filter can't be blank";

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        validateNotNull(image, ERROR_IMAGE_NULL);
        validateNotNull(filter, ERROR_FILTER_NULL);
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        validateNotNull(filter1, ERROR_FILTER_NULL);
        validateNotNull(filter2, ERROR_FILTER_NULL);
        return filter1.andThen(filter2);
    }

    private static void validateNotNull(Object obj, String err) {
        if (obj == null) {
            throw new IllegalArgumentException(err);
        }
    }

}

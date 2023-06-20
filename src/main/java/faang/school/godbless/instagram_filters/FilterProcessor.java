package faang.school.godbless.instagram_filters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        validateArgumentNotNull(image);
        validateArgumentNotNull(function);

        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        validateArgumentNotNull(filter1);
        validateArgumentNotNull(filter2);

        return filter1.andThen(filter2);
    }

    private <T> void validateArgumentNotNull(T argument) {
        if (argument == null) {
            throw new IllegalArgumentException("Argument can't be null");
        }
    }
}

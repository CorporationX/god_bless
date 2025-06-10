package school.faang.bjs2_80443;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        if (image == null) {
            throw new NullPointerException(" image is null");
        }
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}

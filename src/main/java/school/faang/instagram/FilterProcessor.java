package school.faang.instagram;

import java.util.function.Function;
import java.util.stream.Stream;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function combineFilters(Function<Image, Image> filter1,
                                   Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }

    @SafeVarargs
    public final Function<Image, Image> combineMultipleFilters(Function<Image, Image>... filters) {
        return Stream.of(filters)
                .reduce(Function.identity(), Function::andThen);
    }
}

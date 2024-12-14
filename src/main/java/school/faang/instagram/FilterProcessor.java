package school.faang.instagram;

import java.util.Arrays;
import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    @SafeVarargs
    public final Function<Image, Image> combineFilters(Function<Image, Image>... filters) {
        return image -> Arrays.stream(filters)
                .reduce(Function.identity(), Function::andThen)
                .apply(image);
    }
}

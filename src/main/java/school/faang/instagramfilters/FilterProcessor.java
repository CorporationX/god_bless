package school.faang.instagramfilters;

import java.util.Arrays;
import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null || filter == null) {
            throw new IllegalArgumentException("Image and consumer must not be null!");
        }
        return filter.apply(image);
    }

    @SafeVarargs
    public final Function<Image, Image> combineFilters(Function<Image, Image>... filters) {
        return Arrays.stream(filters).reduce(Function.identity(), Function::andThen);
    }
}

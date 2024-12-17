package school.faang.sprint2task46483;

import java.util.Arrays;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image originalImage, Function<Image, Image> grayscaleFilter) {
        return grayscaleFilter.apply(originalImage);
    }

    @SafeVarargs
    public final Function<Image, Image> combineFilters(Function<Image, Image>... filters) {
        return Arrays.stream(filters)
                .reduce(Function.identity(), Function::andThen);
    }
}
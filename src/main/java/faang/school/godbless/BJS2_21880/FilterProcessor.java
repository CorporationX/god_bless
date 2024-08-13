package faang.school.godbless.BJS2_21880;

import java.util.Arrays;
import java.util.function.Function;

public class FilterProcessor {

    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    @SafeVarargs
    public static Function<Image, Image> combineFilters(Function<Image, Image>... filters) {
        return Arrays.stream(filters)
                .reduce(Function::andThen)
                .orElse(Function.identity());
    }
}

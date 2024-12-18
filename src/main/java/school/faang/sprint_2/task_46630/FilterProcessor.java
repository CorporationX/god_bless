package school.faang.sprint_2.task_46630;

import java.util.function.Function;
import java.util.Arrays;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }

    @SafeVarargs
    public final Function<Image, Image> combineFilters(Function<Image, Image>... filters) {
        return Arrays.stream(filters)
                .reduce(Function.identity(), Function::andThen);
    }
}

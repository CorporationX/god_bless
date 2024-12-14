package school.faang.sprint_2.task_46228;

import java.util.Arrays;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image>... filters) {
        return image -> Arrays.stream(filters)
                .reduce(Function.identity(), Function::andThen)
                .apply(image);
    }
}

package school.faang.sprint2.task_bjs246377;

import java.util.Arrays;
import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    @SafeVarargs
    public final Function<Image, Image> combineFilters(Function<Image, Image>... functions) {
        return Arrays.stream(functions)
                .reduce(Function.identity(), Function::andThen);
    }

}

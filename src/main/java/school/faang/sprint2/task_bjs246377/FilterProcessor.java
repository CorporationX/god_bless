package school.faang.sprint2.task_bjs246377;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(BiFunction<Function<Image, Image>, Function<Image, Image>, Function<Image, Image>> filters) {
        return filters.apply();
    }

}

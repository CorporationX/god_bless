package school.faang.sprint_2.task_46384;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter,
                                                 Function<Image, Image> newFilter) {
        return filter.andThen(newFilter);
    }
}

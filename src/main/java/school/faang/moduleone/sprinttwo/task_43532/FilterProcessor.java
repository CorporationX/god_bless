package school.faang.moduleone.sprinttwo.task_43532;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> firstFilter,
            Function<Image, Image> secondFilter) {
        return image -> firstFilter.apply(secondFilter.apply(image));
    }
}

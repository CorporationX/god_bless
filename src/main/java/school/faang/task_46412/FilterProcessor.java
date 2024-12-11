package school.faang.task_46412;

import java.util.function.Function;

public class FilterProcessor {
    protected Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    protected Function<Image, Image> combineFilters(Function<Image, Image> filter, Function<Image, Image> filter2) {
        return (image) -> filter2.apply(filter.apply(image));
    }
}

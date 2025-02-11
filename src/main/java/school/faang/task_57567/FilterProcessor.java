package school.faang.task_57567;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image originalImage, Function<Image, Image> filter) {
        return filter.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return image -> filter2.apply(filter1.apply(image));
    }
}

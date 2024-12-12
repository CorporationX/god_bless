package school.faang.task_46644;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter11, Function<Image, Image> filter22) {
        return image -> filter11.apply(filter22.apply(image));
    }
}

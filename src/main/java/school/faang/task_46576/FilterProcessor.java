package school.faang.task_46576;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image img, Function<Image, Image> filter) {
        return filter.apply(img);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }

}

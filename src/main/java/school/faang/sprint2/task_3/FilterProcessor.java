package school.faang.sprint2.task_3;

import lombok.NonNull;

import java.util.function.Function;


public class FilterProcessor {
    @NonNull
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }
    @NonNull
    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

package school.faang.sprint2.task_46286;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> first,
                                                 @NonNull Function<Image, Image> second) {
        return first.andThen(second);
    }
}

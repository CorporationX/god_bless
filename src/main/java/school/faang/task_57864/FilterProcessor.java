package school.faang.task_57864;


import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> filter1,
                                                 @NonNull Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

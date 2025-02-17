package school.faang.task_57926;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> firstFilter,
                                                 @NonNull Function<Image, Image> secondFilter) {
        Function<Image, Image> combinedFilter = image -> {
            Image afterFirstFilter = firstFilter.apply(image);
            Image afterSecondFilter = secondFilter.apply(afterFirstFilter);
            return afterSecondFilter;
        };

        return combinedFilter;
    }
}

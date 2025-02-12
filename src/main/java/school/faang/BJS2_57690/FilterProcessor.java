package school.faang.BJS2_57690;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(@NonNull Image image,
                             @NonNull Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> firstFilter,
                                                 @NonNull Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}

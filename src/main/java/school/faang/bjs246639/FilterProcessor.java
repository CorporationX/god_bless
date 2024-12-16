package school.faang.bjs246639;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> filterFirst,
                                                 @NonNull Function<Image, Image> filterSecond) {
        return filterFirst.andThen(filterSecond);
    }
}

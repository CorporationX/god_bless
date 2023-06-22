package faang.school.godbless.filter_instagram;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> filterOne, @NonNull Function<Image, Image> filterTwo) {
        return filterOne.andThen(filterTwo);
    }
}

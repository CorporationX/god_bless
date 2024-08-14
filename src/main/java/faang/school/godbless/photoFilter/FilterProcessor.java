package faang.school.godbless.photoFilter;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> firstFunction, @NonNull Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }
}

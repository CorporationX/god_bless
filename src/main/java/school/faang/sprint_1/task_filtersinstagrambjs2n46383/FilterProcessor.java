package school.faang.sprint_1.task_filtersinstagrambjs2n46383;

import lombok.NonNull;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> function1,
                                                 @NonNull Function<Image, Image> function2) {
        return function1.andThen(function2);
    }
}



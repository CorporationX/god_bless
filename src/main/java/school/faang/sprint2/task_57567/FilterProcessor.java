package school.faang.sprint2.task_57567;

import javax.validation.constraints.NotNull;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(@NotNull Image originalImage, @NotNull Function<Image, Image> filter) {
        return filter.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(@NotNull Function<Image, Image> filter1,
                                                 @NotNull Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

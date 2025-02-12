package school.faang.instagramfiltres;

import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(@NonNull Image image,
                             @NonNull Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> filter,
                                                 @NonNull Function<Image, Image> nextFilter) {
        return filter.andThen(nextFilter);
    }


}

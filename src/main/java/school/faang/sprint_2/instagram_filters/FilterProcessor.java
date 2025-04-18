package school.faang.sprint_2.instagram_filters;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public static Function<Image, Image> combineTwoFilters(Function<Image, Image> firstFilter,
                                                         Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }

    @SafeVarargs
    public static Function<Image, Image> combineFilters(Function<Image, Image>... filters) {
        Objects.requireNonNull(filters, "filters cannot be null");
        return Arrays.stream(filters)
                .reduce(Function.identity(), Function::andThen);
    }
}

package school.faang.bjs2_87774;

import java.util.function.Function;

public class FilterProcessor {

    private FilterProcessor() {

    }

    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    @SafeVarargs
    public static Function<Image, Image> combineFilters(Function<Image, Image>... filters) {
        ensureFiltersReady(filters);
        if (filters.length == 2) {
            return filters[0].andThen(filters[1]);
        }

        Function<Image, Image> combinedFilter = filters[0];
        for (int i = 0; i < filters.length; i++) {
            if (i == filters.length - 1) {
                return combinedFilter;
            }
            combinedFilter = combinedFilter.andThen(filters[i + 1]);
        }
        return combinedFilter;
    }

    @SafeVarargs
    private static void ensureFiltersReady(Function<Image, Image>... filters) {
        if (filters == null || filters.length == 1) {
            throw new IllegalArgumentException("there must be at least two filters for the combination");
        }

    }
}

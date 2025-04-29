package school.faang.functional_interfaces.bjs2_70559.instagram_filters;

import lombok.extern.slf4j.Slf4j;
import java.util.function.Function;

@Slf4j
public class FilterProcessor {
    private static final String FILTER_NOT_FOUND = "Filter is not found";

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (filter == null) {
            log.error(FILTER_NOT_FOUND);
            throw new FilterNotFound(FILTER_NOT_FOUND);
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        if (filter1 == null || filter2 == null) {
            log.error(FILTER_NOT_FOUND);
            throw new FilterNotFound(FILTER_NOT_FOUND);
        }
        return filter1.andThen(filter2);
    }
}

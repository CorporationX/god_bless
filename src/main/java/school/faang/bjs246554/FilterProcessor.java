package school.faang.bjs246554;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null || filter == null) {
            log.error("Image or filter is null.");
            throw new IllegalArgumentException("Image or filter cannot be null.");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        if (firstFilter == null || secondFilter == null) {
            log.error("First filter or second filter is null.");
            throw new IllegalArgumentException("Filters cannot be null.");
        }
        return firstFilter.andThen(secondFilter);
    }
}
package school.faang.filtersinstbjs46494;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filters) {
        return filters.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1,
                                                 Function<Image, Image> filter2) {
        return (image) -> filter2.apply(filter1.apply(image));
    }
}

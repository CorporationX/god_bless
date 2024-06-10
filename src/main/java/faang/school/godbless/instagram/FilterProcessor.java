package faang.school.godbless.instagram;

import java.awt.*;
import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if(image == null) {
            throw new IllegalArgumentException("Image not be null");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> initialFilter,
                                                 Function<Image, Image> finalizeFilter) {
        return initialFilter.andThen(finalizeFilter);
    }
}

package dima.evseenko.instagram;

import java.util.Objects;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (Objects.nonNull(image) && Objects.nonNull(filter)) {
            return filter.apply(image);
        }
        return image;
    }

    public Image combineFilters(Image image, Function<Image, Image>... filters) {
        if (Objects.nonNull(filters)) {
            Image filtered = new Image(image.getName(), image.getDescription());
            for (Function<Image, Image> filter : filters) {
                filtered = applyFilter(filtered, filter);
            }
            return filtered;
        }
        return image;
    }
}

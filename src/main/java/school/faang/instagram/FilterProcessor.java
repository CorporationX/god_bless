package school.faang.instagram;

import java.util.Objects;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        Objects.requireNonNull(image);
        Objects.requireNonNull(filter);
        return filter.apply(image);
    }

    public Image combineFilters(Image image, Function<Image, Image> filter1, Function<Image, Image> filter2) {
        Objects.requireNonNull(image);
        Objects.requireNonNull(filter1);
        Objects.requireNonNull(filter2);

        Image modifiedImage = filter1.apply(image);
        return filter2.apply(modifiedImage);
    }
}

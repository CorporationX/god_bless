package instagram;

import java.util.Objects;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        Objects.requireNonNull(image, "Image cannot be null");
        Objects.requireNonNull(filter, "Filter cannot be null");

        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        Objects.requireNonNull(filter1, "First filter cannot be null");
        Objects.requireNonNull(filter2, "Second filter cannot be null");

        return filter1.andThen(filter2);
    }
}

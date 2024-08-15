package BJS2_21902_Instagram;

import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> first, Function<Image, Image> second) {
        return first.andThen(second);
    }
}

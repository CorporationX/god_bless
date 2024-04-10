package BJS2_5161;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null || filter == null) {
            throw new NullPointerException("Passed args can't be null");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> first, Function<Image, Image> second) {
        return first.andThen(second);
    }
}

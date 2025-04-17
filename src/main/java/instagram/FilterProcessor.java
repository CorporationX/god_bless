package instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> f1, Function<Image, Image> f2) {
        return f1.andThen(f2);
    }
}

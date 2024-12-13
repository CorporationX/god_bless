package school.faang.bjs246454;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image original, Function<Image, Image> filter) {
        Image image = filter.apply(original);
        return image;
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

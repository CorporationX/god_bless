package school.faang.tast_46611;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image originImage, Function<Image, Image> filter) {
        return filter.apply(originImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

package school.faang.bjs2_87774;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> fstFilter, Function<Image, Image> sndFilter) {
        return fstFilter.compose(sndFilter);
    }
}

package faang.school.godbless.InstagramFilters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> oneFilter, Function<Image, Image> twoFilter) {
    return (image -> {
        Image apply = oneFilter.apply(image);
        apply = twoFilter.apply(apply);
        return apply;
    });
    }
}

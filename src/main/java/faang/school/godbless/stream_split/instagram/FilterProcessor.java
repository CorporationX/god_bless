package faang.school.godbless.stream_split.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterMain, Function<Image, Image> filterSide) {
        return filterMain.andThen(filterSide);
    }
}

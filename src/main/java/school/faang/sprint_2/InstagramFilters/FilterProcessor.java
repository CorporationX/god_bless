package school.faang.sprint_2.InstagramFilters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> newFilter) {
        return newFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return secondFilter.compose(firstFilter);
//        return firstFilter.andThen(secondFilter);
    }
}

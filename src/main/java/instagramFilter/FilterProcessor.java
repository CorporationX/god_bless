package instagramFilter;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> photoWithFilter) {
        return photoWithFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter){
        return firstFilter.andThen(secondFilter);
    }
}

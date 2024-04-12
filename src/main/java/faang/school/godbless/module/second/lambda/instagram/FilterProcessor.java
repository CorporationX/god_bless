package faang.school.godbless.module.second.lambda.instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null || filter == null) {
            return null;
        }
        return filter.apply(image);
    }
    
    public Function<Image,Image> combineFilters(Function<Image,Image> firstFilter,Function<Image,Image> secondFilter) {
        if (firstFilter == null || secondFilter == null) {
            return null;
        }
        return firstFilter.andThen(secondFilter);
    }
}

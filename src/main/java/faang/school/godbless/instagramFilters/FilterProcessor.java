package faang.school.godbless.instagramFilters;

import java.util.function.Function;

public class FilterProcessor {
    Image applyFilter(Image image, Function<Image, Image> imageFilter ) {
        System.out.println();
        return imageFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter){
        return firstFilter.andThen(secondFilter);
    }

}

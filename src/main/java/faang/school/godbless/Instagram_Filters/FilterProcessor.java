package faang.school.godbless.Instagram_Filters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> imageFunction) {
        return imageFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstImageFunction, Function<Image, Image> secondImageFunction) {
        return firstImageFunction.andThen(secondImageFunction);
    }
}


package BJS2_9890;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> newImage) {
        return newImage.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterFirst, Function<Image, Image> filterSecond) {
        return filterFirst.andThen(filterSecond);
    }
}

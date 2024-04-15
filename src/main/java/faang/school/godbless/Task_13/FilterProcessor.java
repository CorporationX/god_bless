package faang.school.godbless.Task_13;

import java.util.function.Function;

public class FilterProcessor {
    Image applyFilter(Image image, Function<Image, Image> newImage) {
        return newImage.apply(image);
    }

    Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterAnother) {
        return (image) -> filterOne.apply(filterAnother.apply(image));
    }
}

package faang.school.godbless.Sprint3.task3;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> photoFilter) {
        return photoFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> photoFilter1, Function<Image, Image> photoFilter2) {
        return photoFilter1.andThen(photoFilter2);
    }
}

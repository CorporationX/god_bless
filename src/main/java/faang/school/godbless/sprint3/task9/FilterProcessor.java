package faang.school.godbless.sprint3.task9;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Image не может быть null!");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Filter не может быть null!");
        }
        return filter.apply(image);
    }

    public Function<Image,Image> combineFilters(Function<Image,Image> filter1, Function<Image,Image> filter2) {
        if (filter1 == null || filter2 == null) {
            throw new IllegalArgumentException("Filter не может быть null!");
        }
        return filter1.andThen(filter2);
    }
}

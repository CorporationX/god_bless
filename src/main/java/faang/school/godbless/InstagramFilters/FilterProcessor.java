package faang.school.godbless.InstagramFilters;

import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    // Метод combineFilters комбинирует два фильтра
    public static Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

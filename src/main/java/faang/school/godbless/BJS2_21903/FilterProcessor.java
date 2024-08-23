package faang.school.godbless.BJS2_21903;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filterFunction) {
        return filterFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilterFunction, Function<Image, Image> secondFilterFunction) {
        return firstFilterFunction.andThen(secondFilterFunction);
    }
}

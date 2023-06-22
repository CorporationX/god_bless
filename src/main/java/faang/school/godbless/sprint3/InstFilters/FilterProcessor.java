package faang.school.godbless.sprint3.InstFilters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return image -> function1.apply(function2.apply(image));
    }
}

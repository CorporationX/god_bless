package faang.school.godbless.sprint3.InstagramsFilters.classes;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFunction, Function<Image, Image> secondFunction) {
        return image -> secondFunction.apply(firstFunction.apply(image));
    }
}

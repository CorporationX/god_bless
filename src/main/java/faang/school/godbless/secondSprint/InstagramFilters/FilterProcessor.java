package faang.school.godbless.secondSprint.InstagramFilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function, Function<Image, Image> secFunction) {
        return image -> function.andThen(secFunction).apply(image);
    }
}

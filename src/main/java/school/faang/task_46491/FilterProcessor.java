package school.faang.task_46491;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFunction,
                                                 Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }
}

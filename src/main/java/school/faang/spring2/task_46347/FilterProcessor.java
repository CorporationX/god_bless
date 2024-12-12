package school.faang.spring2.task_46347;

import java.util.Arrays;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return function1.andThen(function2);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image>... functions) {
        return Arrays.stream(functions)
                .reduce(Function.identity(), Function::andThen);
    }
}

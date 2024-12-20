package faang.school.godbless.sprint_2.task_46313;

import java.util.Arrays;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return function1.andThen(function2);
    }

    @SafeVarargs
    public final Function<Image, Image> combineMultipleFilters(Function<Image, Image>... functions) {
        return Arrays.stream(functions).reduce(Function.identity(), Function::andThen);
    }
}

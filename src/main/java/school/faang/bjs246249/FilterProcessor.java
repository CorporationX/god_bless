package school.faang.bjs246249;

import java.util.Arrays;
import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    @SafeVarargs
    public final Function<Image, Image> combineFilters(Function<Image, Image>... functions) {
        return Arrays.stream(functions)
                .reduce(Function.identity(), Function::compose);
    }

}

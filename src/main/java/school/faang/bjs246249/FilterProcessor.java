package school.faang.bjs246249;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    @SafeVarargs
    public final Function<Image, Image> combineFilters(Function<Image, Image>... functions) {
        Function<Image, Image> result = Function.identity();
        for (Function<Image, Image> function : functions) {
            result = result.compose(function);
        }
        return result;
    }

}

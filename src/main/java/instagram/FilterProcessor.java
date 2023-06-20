package instagram;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filterApp) {
        return filterApp.apply(image);
    }

    public Function<Image, Image> combineFilter (Function<Image, Image> firstFunc, Function<Image, Image> secondFunc) {
        Function<Image, Image> function = image -> firstFunc.apply(secondFunc.apply(image));
        return function;
    }

}

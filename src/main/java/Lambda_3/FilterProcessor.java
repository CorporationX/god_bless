package Lambda_3;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> functionFirst, Function<Image, Image> functionSecond) {
        return functionFirst.andThen(functionSecond);
    }


}

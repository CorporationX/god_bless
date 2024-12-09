package school.faang.bjs246249;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> functionOne,
                                                 Function<Image, Image> functionTwo) {
        return functionTwo.compose(functionOne);
    }

}

package school.faang.bjs2_91909;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filterFunction) {
        return filterFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterFunction,
                                                 Function<Image, Image> filterFunction2) {
        return filterFunction.andThen(filterFunction2);
    }
}

package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> imageFunction) {
        return imageFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> imageFunction,
                                                 Function<Image, Image> function) {
        return imageFunction.andThen(function);
    }
}

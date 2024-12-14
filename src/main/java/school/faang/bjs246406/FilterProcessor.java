package school.faang.bjs246406;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageFunction) {
        return imageFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> imageFunction1,
                                                 Function<Image, Image> imageFunction2) {
        return imageFunction1.andThen(imageFunction2);
    }
}
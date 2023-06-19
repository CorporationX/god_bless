package faang.school.godbless.lambda.insta;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageFunction) {
        return imageFunction.apply(image);
    }
    public Function<Image, Image> combineFilters(Function<Image, Image> imageFunction1, Function<Image, Image> imageFunction2) {
        Function<Image, Image> combinedFilter = (image) -> imageFunction1.apply(imageFunction2.apply(image));
        return combinedFilter;
    }
}

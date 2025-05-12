package faang.school;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstImage,
                                                 Function<Image, Image> secondImage) {
        return firstImage.andThen(secondImage);
    }
}

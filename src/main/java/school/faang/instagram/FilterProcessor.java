package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> imageProcessor) {
        return imageProcessor.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> imageProcessor1, Function<Image, Image> imageProcessor2) {
        return imageProcessor1.andThen(imageProcessor2);
    }
}

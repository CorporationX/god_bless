package school.faang.Sprint2.Instagram;

import java.util.function.Function;

public class FilterProcessor {


    public Image applyFilter(Image originalImage, Function<Image, Image> grayscaleFilter) {
        return grayscaleFilter.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> grayscaleFilter, Function<Image, Image> sepiaFilter) {
    return grayscaleFilter.andThen(sepiaFilter);
    }
}

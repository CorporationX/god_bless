package school.faang.sprint2task46483;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image originalImage, Function<Image, Image> grayscaleFilter) {
        return grayscaleFilter.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}
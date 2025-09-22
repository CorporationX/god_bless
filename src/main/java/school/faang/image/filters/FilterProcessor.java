package school.faang.image.filters;

import java.util.function.Function;


public class FilterProcessor {

    public Image applyFilter(Image originalImage, Function<Image, Image> filter) {
        return filter.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        return (originalImage) -> {
            Image intermediateImage = applyFilter(originalImage, firstFilter);
            return applyFilter(intermediateImage, secondFilter);
        };
    }
}

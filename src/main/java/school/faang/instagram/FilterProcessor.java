package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function combineFilters(Function<Image, Image> filter1,
                                   Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }

    public Function<Image, Image> combineMultipleFilters(Function<Image, Image>... filters) {
        return image -> {
            Image result = image;
            for (Function<Image, Image> filter : filters) {
                result = filter.apply(result);
            }
            return result;
        };
    }
}

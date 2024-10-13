package InstagramFilter;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> modifier) {
        return modifier.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstModifier, Function<Image, Image> secondModifier) {
        return firstModifier.andThen(secondModifier);
    }
}

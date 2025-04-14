package instagram.filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> transformFunction) {
        return transformFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        Function<Image, Image> combinedFunction = image -> new Image("Combined filters", firstFilter
                        .apply(new Image("Combined", secondFilter
                                .apply(image).getDescription())).getDescription());
        return combinedFunction;
    }
}

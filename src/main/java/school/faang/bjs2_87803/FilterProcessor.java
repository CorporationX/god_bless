package school.faang.bjs2_87803;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        Image filter = function.apply(image);
        return filter;
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return (Image input) -> {
            Image firstResult = filter1.apply(input);
            Image secondResult = filter2.apply(firstResult);
            return secondResult;
        };
    }
}

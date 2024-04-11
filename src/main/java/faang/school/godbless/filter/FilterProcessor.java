package faang.school.godbless.filter;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function){
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return image -> {
            Image result1 = filter1.apply(image);
            Image result2 = filter2.apply(result1);
            return new Image(result2.getFileName(), result1.getDescription() + " / " + result2.getDescription());
        };
    }
}

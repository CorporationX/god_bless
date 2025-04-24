package school.faang.instagram_filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> changeImage) {
        return changeImage.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1,
                                                 Function<Image, Image> function2){
        return function1.andThen(function2);
    }
}

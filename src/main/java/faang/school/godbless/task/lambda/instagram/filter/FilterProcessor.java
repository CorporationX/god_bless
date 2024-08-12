package faang.school.godbless.task.lambda.instagram.filter;

import java.util.function.Function;

public class FilterProcessor {
    
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1,
                                                 Function<Image, Image> function2) {
        Function<Image, Image> combineFunction = image -> {
            image = function1.apply(image);
            image = function2.apply(image);
            return image;
        };
        return combineFunction;
    }
}

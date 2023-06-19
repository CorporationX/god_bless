package faang.school.godbless.sprint3.task9;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        if (image == null) {
            throw new NullPointerException("Image не может быть null!");
        }
        if (function == null) {
            throw new NullPointerException("Function не может быть null!");
        }
        return function.apply(image);
    }

    public Function<Image,Image> combineFilters(Function<Image,Image> function1, Function<Image,Image> function2) {
        if (function1 == null || function2 == null) {
            throw new NullPointerException("Function не может быть null!");
        }
        return function1.andThen(function2);
    }
}

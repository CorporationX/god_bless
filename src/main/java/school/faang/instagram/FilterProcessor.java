package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        if (image == null || function == null) {
            System.out.println("Значение не может быть null");

        } else {
            return function.apply(image);
        }
        return image;
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        if (function1 == null || function2 == null) {
            System.out.println("Значение не может быть null");
        } else {
            return function1.andThen(function2);
        }
        return Function.identity();
    }
}
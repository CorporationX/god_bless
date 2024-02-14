package Task3;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function){
        return function.apply(image);
    }
    public Function<Image, Image> combineFilter(Function<Image, Image> function1, Function<Image, Image> function2){
        return function1.andThen(function2);
    }
}

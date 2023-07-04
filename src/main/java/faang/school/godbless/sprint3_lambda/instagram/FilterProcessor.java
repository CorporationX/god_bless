package main.java.faang.school.godbless.sprint3_lambda.instagram;
import java.util.function.Function;
public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function){
        return function.apply(image);
    }
    public Function<Image, Image> combineFilters(Function<Image, Image> first, Function<Image, Image> second){
        return first.andThen(second);
    }
}

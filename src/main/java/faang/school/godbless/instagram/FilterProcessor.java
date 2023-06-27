package main.java.faang.school.godbless.instagram;
import java.util.function.Function;
public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function){
        return function.apply(image);
    }
    public Function<Image, Image> combineFilters(Function<Image, Image> one, Function<Image, Image> two){
        return one.andThen(two);
    }
}

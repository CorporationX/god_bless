import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> newImage){
        return newImage.apply(image);
    }
    public static Function<Image, Image> combineFilters(Function<Image, Image> firstFunction, Function<Image, Image> secondFunction){
        return firstFunction.andThen(secondFunction);
    }
}

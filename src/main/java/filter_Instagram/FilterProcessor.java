package filter_Instagram;

public class FilterProcessor {


    @FunctionalInterface
    public interface Function<U, V> {
        U apply(V param);
    }
    public static Image applyFilter(Image image, Function<Image, Image>imageFunction){
        return imageFunction.apply(image);
    }
    public static Function<Image, Image> combineFilters(Function<Image, Image>imageFunction1, Function<Image, Image>imageFunction2){
        return image ->imageFunction2.apply(imageFunction1.apply(image));
    }
}

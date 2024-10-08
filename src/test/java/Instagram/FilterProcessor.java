package Instagram;

import java.util.function.Function;

public class FilterProcessor {

    public static  void applyFilter(Image image, Function<Image,Image> filter){
        System.out.println("Filter applied to photo "+ filter.apply(image));
    }
    public static Function<Image,Image> combineFilters (Function<Image,Image> filter, Function<Image,Image> anotherfilter){
        return image -> anotherfilter.apply(filter.apply(image));
    }
}
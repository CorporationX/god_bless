package Filters_Instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image,Image> function){
        Image newImage = function.apply(image);
        return newImage;
    }

    public Function<Image,Image> combineFilters (Function<Image, Image> f1,
                                                 Function<Image,Image> f2){
        Function<Image,Image> newFilter = f1.andThen(f2);
        return newFilter;
    }

}

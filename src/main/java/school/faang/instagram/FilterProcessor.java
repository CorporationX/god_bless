package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image,Image> imageFunction){

       Image applyFilter = imageFunction.apply(image);

        return applyFilter;
    }

    public Function<Image, Image> combineFilters(Function<Image,Image> firstImageFilter, Function<Image,Image> secondImageFilter){

        return firstImageFilter.andThen(secondImageFilter);
    }
}

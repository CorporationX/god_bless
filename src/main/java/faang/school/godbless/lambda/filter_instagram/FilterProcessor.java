package faang.school.godbless.lambda.filter_instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function){
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter, Function<Image,Image> filter1){
        return filter.andThen(filter1);
    }
}

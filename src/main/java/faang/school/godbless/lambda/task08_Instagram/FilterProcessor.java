package faang.school.godbless.lambda.task08_Instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageFunction){
        return imageFunction.apply(image);
    }
    public Function<Image, Image> combineFilters(Function<Image, Image> firstImageFunction, Function<Image, Image> secondImageFunction){
        return x -> firstImageFunction.andThen(secondImageFunction).apply(x);
    }
}

package faang.school.godbless;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageImageFunction){
        return imageImageFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> imageImageFunction, Function<Image, Image> imageImageFunction2){
        return imageImageFunction.andThen(imageImageFunction2);
    }



}

package faang.school.godbless.instagramFilters;

import java.util.function.Function;

public class FilterProcessor {
    Image applyFilter(Image image, Function<Image, Image> functionImage) {
        return functionImage.apply(image);
    }

    Function<Image, Image> combineFilters(Function<Image, Image> functionImageFirst, Function<Image, Image> functionImageSecond){
        return functionImageFirst.andThen(functionImageSecond);
    }
}

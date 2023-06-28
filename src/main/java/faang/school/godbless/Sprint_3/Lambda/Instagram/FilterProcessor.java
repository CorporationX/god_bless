package faang.school.godbless.Sprint_3.Lambda.Instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image img, Function<Image, Image> func) {
        return func.apply(img);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> func1, Function<Image, Image> func2) {
        return func1.andThen(func2);
    }

}

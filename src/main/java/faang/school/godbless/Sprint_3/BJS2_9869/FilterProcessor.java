package faang.school.godbless.Sprint_3.BJS2_9869;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filterFunction) {
        return filterFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
//        return (image) -> filterTwo.apply(filterOne.apply(image));
        return filterTwo.andThen(filterOne);
    }
}


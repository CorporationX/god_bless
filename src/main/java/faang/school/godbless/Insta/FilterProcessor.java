package faang.school.godbless.Insta;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
//        System.out.println(filter.apply(image));
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
//        System.out.println(filterOne.andThen(filterTwo));
        return filterOne.andThen(filterTwo);
    }
}

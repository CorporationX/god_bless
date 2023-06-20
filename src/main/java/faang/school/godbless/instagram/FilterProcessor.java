package faang.school.godbless.instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image originalImg, Function<Image, Image> filterFn) {
      return filterFn.apply(originalImg);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFn, Function<Image, Image> secondFn) {
        return firstFn.andThen(secondFn);
    }
}

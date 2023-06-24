package faang.school.god_bless.instagram_filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> functionOne, Function<Image, Image> functionTwo) {
        return functionOne.andThen(functionTwo);
    }
}

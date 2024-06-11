package faang.school.godbless.Task_Instagram_Filter;

import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor
public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filterFunc) {
        return filterFunc.apply(image);
    }

    public Function<Image, Image> combineFilters (
            Function<Image, Image> func2, Function<Image, Image> func1) {
        return func1.andThen(func2);
    }

}

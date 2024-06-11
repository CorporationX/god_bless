package faang.school.godbless.module1.sprint2.task4;

import lombok.ToString;

import java.util.function.Function;

@ToString
public class FilterProcessor {


    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        return image -> firstFilter.apply(secondFilter.apply(image));
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter,
                                                 Function<Image, Image> thirdFilter) {
        return firstFilter.andThen(secondFilter).andThen(thirdFilter);
    }

}

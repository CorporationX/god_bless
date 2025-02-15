package school.faang.instagram;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        checkArguments(image, filter);
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        checkArguments(firstFilter, secondFilter);
        return firstFilter.andThen(secondFilter);
    }

    public void checkArguments(Object objectFirst, Object objectSecond) {
        if (objectFirst == null || objectSecond == null) {
            throw new IllegalArgumentException("Переменная не может быть равна null");
        }
    }
}
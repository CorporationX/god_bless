package school.faang.instagram;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        checkArguments(image, filter);
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        checkArguments(filter1, filter2);
        return filter1.andThen(filter2);
    }

    public void checkArguments(Object objectFirst, Object objectSecond) {
        if (objectFirst == null || objectSecond == null) {
            throw new IllegalArgumentException();
        }

        if (objectFirst instanceof String) {
            String string = objectFirst.toString();
            if (string.isBlank()) {
                throw new IllegalArgumentException();
            }
        }

        if (objectSecond instanceof String) {
            String string = objectSecond.toString();
            if (string.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }
}

package faang.school.godbless.bjs2_5011;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;
import java.util.function.Function;

@Slf4j
public class FilterProcessor {

    private static final String NO_ARGUMENTS = "Not enough arguments: ";
    private static final String NO_IMAGE = NO_ARGUMENTS + "image";
    private static final String NO_FILTER = NO_ARGUMENTS + "filter";

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            log.error(NO_IMAGE);
            throw new NoSuchElementException(NO_IMAGE);
        }
        if (filter == null) {
            log.error(NO_FILTER);
            throw new NoSuchElementException(NO_FILTER);
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        if (filter1 == null || filter2 == null) {
            log.error(NO_FILTER);
            throw new NoSuchElementException(NO_FILTER);
        }
        return (image) -> filter2.apply(filter1.apply(image));
    }
}

package faang.school.godbless.sprint2.BJS2_21896;

import java.util.Objects;
import java.util.function.Function;

public class FilterProcessor {

    protected Image applyFilter(Image image, Function<Image, Image> function) {
        Objects.requireNonNull(image);
        Objects.requireNonNull(function);

        return function.apply(image);
    }

    protected Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        Objects.requireNonNull(function1);
        Objects.requireNonNull(function2);

        return function1.andThen(function2);
    }
}

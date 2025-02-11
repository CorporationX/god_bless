package task_BJS2_57679;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(@NonNull Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combinedFilter(Function<Image, Image> firstFunction,
                                                 Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }
}

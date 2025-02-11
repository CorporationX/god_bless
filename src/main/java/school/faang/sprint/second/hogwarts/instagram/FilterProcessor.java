package school.faang.sprint.second.hogwarts.instagram;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> function) {
        if (image.getName().isBlank()) {
            throw new IllegalArgumentException("Image name cannot be blank");
        }
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> firstFunction,
                                                 @NonNull Function<Image, Image> secondFunction) {
        return firstFunction.andThen(secondFunction);
    }
}

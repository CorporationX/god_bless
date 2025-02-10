package school.faang.sprint2.task_BJS2_57660;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        checkImage(image);
        checkFunction(function);

        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        checkFunction(function1);
        checkFunction(function2);
        return function1.andThen(function2);
    }

    private void checkImage(Image image) {
        if (image == null) {
            throw new IllegalArgumentException("Фото не может быть null");
        }
    }

    private void checkFunction(Function<Image, Image> function) {
        if (function == null) {
            throw new IllegalArgumentException("Функция не может быть пустой");
        }
    }
}

package school.faang.task_46403;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> func, Function<Image, Image> funct) {
        return func.andThen(funct);
    }
}

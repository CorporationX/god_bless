package school.faang.task_46664;

import java.util.function.Function;

public class FilterProcessor {

    public final Image applyFilter(Image image, Function<Image, Image> f) {
        return f.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> f1, Function<Image, Image> f2) {
        return f1.andThen(f2);
    }


}

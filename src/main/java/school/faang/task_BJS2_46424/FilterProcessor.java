package school.faang.task_BJS2_46424;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image,Image> filter){
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1,
                                                 Function<Image, Image> function2){
        return function1.andThen(function2);
    }

    public Image combineFilters(Image Image, Function<Image, Image> function1,
                                Function<Image, Image> function2){
        return function2.apply(function1.apply(Image));
    }
}

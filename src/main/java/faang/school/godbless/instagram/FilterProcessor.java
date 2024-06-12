package faang.school.godbless.instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image,Image> handler) {
        return handler.apply(image);
    }
    public Function<Image,Image> combineFilters(Function<Image,Image> firstAction,Function<Image,Image> secondAction){
        return (image) -> secondAction.apply(firstAction.apply(image));
    }
}

package faang.school.godbless.insta;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> handler) {
        return handler.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> handler1, Function<Image, Image> handler2) {
        return image -> {
            return handler2.apply(handler1.apply(image));
        };
    }
}

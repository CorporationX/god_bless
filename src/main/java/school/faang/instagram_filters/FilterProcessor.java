package school.faang.instagram_filters;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> f) {
        return f.apply(image);
    }

    @SuppressWarnings("checkstyle:WhitespaceAround")
    public Image combineFilters(Image image, Function<Image, Image> f, Function<Image, Image> f2){
        return  f.andThen(f2).apply(image);
    }
}
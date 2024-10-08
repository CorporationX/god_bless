package school.faang.instragramfilter;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter){
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> first, Function<Image, Image> second){
        return image -> first.andThen(second).apply(image);
    }
}

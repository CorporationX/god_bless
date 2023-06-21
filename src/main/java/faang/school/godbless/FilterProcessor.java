package faang.school.godbless;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function){
        checkNotNull(image, function);
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        checkNotNull(filter1, filter2);
        return filter1.andThen(filter2);
    }

    private  <V, N> void checkNotNull(V argument1, N argument2){
        if(argument1 == null || argument2 == null){
            throw new IllegalArgumentException("Arguments cannot be null");
        }
    }
}

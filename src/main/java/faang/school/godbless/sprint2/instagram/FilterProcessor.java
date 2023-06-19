package faang.school.godbless.sprint2.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image>  function){
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters (Function<Image, Image> function , Function<Image, Image> secondFunction){
        return function.andThen(secondFunction);
    }

}

package school.faang.bjs270519;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
        //Function<Image, Image> принимает и возвращает Image;
        //apply применяет функцию к обьекту
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterA, Function<Image, Image> filterB) {
        return filterA.andThen(filterB);
    }
}

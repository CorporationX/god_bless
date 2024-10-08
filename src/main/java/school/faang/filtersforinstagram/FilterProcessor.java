package school.faang.filtersforinstagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageFunction) {
        Image result = new Image("AfterFilter", "This image after filter");
        return imageFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return (image) -> function2.apply(function1.apply(image));
    }


}

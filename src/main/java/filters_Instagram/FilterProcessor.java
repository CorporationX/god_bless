package filters_Instagram;

import java.util.function.Function;

public class FilterProcessor {

    Function<Image, Image> BlackWhite = (image -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый"));
    Function<Image, Image> sepia = (image -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия"));

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return function1.andThen(function2);
    }

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }
}
package faang.school.godbless.instagram_filters;

import java.util.function.Function;

public class FilterProcessor {

    Function<Image, Image> grayScaleFilter = image -> new Image(image.getName() + "_grayscale"
            , "Фильтр: черно-белый");

    Function<Image, Image> sepiaFilter = image -> new Image(image.getName() + "_sepia"
            , "Фильтр: сепия");

    Function<Image, Image> vignetteFilter = image -> new Image(image.getName() + "_vignette"
            , "Фильтр: виньетка");

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}

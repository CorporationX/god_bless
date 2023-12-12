package Instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        return image -> {
            image = filterOne.apply(image);
            //В description у картинки будет описание ТОЛЬКО ВТОРОГО фильтра
            return filterTwo.apply(image);
        };
    }
}

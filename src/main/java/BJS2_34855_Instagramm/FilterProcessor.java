package BJS2_34855_Instagramm;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilter(Function<Image, Image> filterFirst, Function<Image, Image> filterSecond) {
        return image -> filterSecond.apply(filterFirst.apply(image));
    }

}

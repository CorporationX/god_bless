package faang.school.godbless.instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filer) {
        return filer.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filer1, Function<Image, Image> filer2) {
        return filer1.andThen(filer2);
    }
}

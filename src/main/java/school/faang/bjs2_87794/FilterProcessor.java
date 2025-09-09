package school.faang.bjs2_87794;

import java.util.function.Function;

public class FilterProcessor {
    private FilterProcessor() {

    }

    public static Image applyFilter(Image image, Function<Image, Image> function) {
        if (image.getDescription() == null || image.getFileName() == null) {
            throw new IllegalArgumentException("Название файла изображения и его описание не могут быть null!");
        }

        return function.apply(image);
    }

    public static Function<Image, Image> combineFilter(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        Function<Image, Image> combinedFilter = (img) -> filter1.apply(filter2.apply(img));
        return combinedFilter;
    }
}
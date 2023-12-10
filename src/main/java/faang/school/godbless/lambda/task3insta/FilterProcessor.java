package faang.school.godbless.lambda.task3insta;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filer) {
        return filer.apply(image);
    }
}

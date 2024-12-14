package school.faang.sprint2.bjs_46525;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        isNull(image, filter);

        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        isNull(filter1, filter2);

        return filter1.andThen(filter2);
    }

    private void isNull(Object object1, Object object2) {
        if (object1 == null || object2 == null) {
            throw new IllegalArgumentException("Введенные значения не могут быть равны null!");
        }
    }
}

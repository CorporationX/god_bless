package faang.school.godbless.sprint_3.instagram_filtres;

import java.util.function.Consumer;
import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> first, Function<Image, Image> second) {
        return first.andThen(second);
    }
    public void showCurrentFilter(Image image,Consumer<Image> consumer){
        consumer.accept(image);
    }
}

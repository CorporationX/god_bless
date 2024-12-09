package school.faang.task_46274;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (filter == null) {
            System.out.println("Данный фильтр отсутсвует!");
            return null;
        } else {
            return filter.apply(image);
        }
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        if (filter1 == null && filter2 == null) {
            System.out.println("Данный фильтр отсутсвует!");
            return null;
        } else {
            return filter1.andThen(filter2);
        }
    }

}

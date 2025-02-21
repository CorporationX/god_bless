package school.faang.task_BJS2_57908;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        //проверяем на null входящие значения
        if (image == null || filter == null) {
            throw new IllegalArgumentException("Image or Filter can not be nill");
        }
        //применяем фильтр к изображению и возрващаем обновленное изображение
        Image imageAfterApplyFilter = filter.apply(image);
        return imageAfterApplyFilter;
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> firstFilter,
            Function<Image, Image> secondFilter) {
        //проверяем на null входящие значения
        if (firstFilter == null || secondFilter == null) {
            throw new IllegalArgumentException("Both filters must not be null");
        }

        //применяем два фильтра к изображению и возрващаем обновленное изображение
        return image -> secondFilter.apply(firstFilter.apply(image));
    }
}
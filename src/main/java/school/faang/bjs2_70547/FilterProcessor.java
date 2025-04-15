package school.faang.bjs2_70547;

import java.util.function.Function;

public class FilterProcessor {
    /**
     * Функция применяет фильтр к изображению. Фильтр — это функция, которая берёт одно изображение и
     * возвращает новое с изменениями. Метод applyFilter принимает объект типа Image и функцию высокого
     * порядка для применения фильтра, возвращает новый объект типа Image с применённым фильтром
     */
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    /**
     * Функция объединяет два фильтра в один, чтобы они применялись последовательно.
     * Принимает две функции высокого порядка и возвращает новую функцию высокого порядка,
     * которая последовательно применяет обе функции
     */
    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
        Function<Image, Image> secondFilter
    ) {
        return firstFilter.andThen(secondFilter);
    }
}

package faang.school.godbless.BJS2_9819;


/*
Создайте класс FilterProcessor с методами:
applyFilter: принимает объект типа Image и функцию высокого порядка для применения фильтра (например, Function<Image, Image>),
 возвращает новый объект типа Image с применённым фильтром;
 combineFilters: принимает две функции высокого порядка и возвращает новую функцию высокого порядка, которая последовательно применяет обе функции.
 */

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageFunction) {
        if (image == null || imageFunction == null) throw new IllegalArgumentException();

        return imageFunction.apply(image);
    }


    public Function<Image, Image> combineFilters(Function<Image, Image> imageFilterOne, Function<Image, Image> imageFilterTwo) {
        if (imageFilterOne == null || imageFilterTwo == null) throw new IllegalArgumentException();

        return (image) -> imageFilterTwo.apply(imageFilterOne.apply(image));
    }
}

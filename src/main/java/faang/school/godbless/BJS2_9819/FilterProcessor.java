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
        Image newImage = null;
        if (image != null || imageFunction != null) {
            newImage = imageFunction.apply(image);
        }
        return newImage;
    }


    public Function<Image, Image> combineFilters(Function<Image, Image> imageFilterOne, Function<Image, Image> imageFilterTwo) {
        Function<Image, Image> function = null;
        if (imageFilterOne != null || imageFilterTwo != null) {
            function = (image) -> imageFilterTwo.apply(imageFilterOne.apply(image));
        }
        return function;
    }
}

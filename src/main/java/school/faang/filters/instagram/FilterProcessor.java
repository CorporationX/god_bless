package school.faang.filters.instagram;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class FilterProcessor {

    Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        return filterOne.andThen(filterTwo);
    }

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: сепия");
        Function<Image, Image> inversionFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: инверсия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Function<Image, Image> combinedFilterOne = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImageOne = filterProcessor.applyFilter(originalImage, combinedFilterOne);
        System.out.println(combinedImageOne.description());

        Image inversionImage = filterProcessor.applyFilter(originalImage, inversionFilter);
        System.out.println(inversionImage.description());

        Function<Image, Image> combinedFilterTwo = filterProcessor.combineFilters(grayscaleFilter, inversionFilter);
        Image combinedImageTwo = filterProcessor.applyFilter(originalImage, combinedFilterTwo);
        System.out.println(combinedImageTwo.description());
    }
}

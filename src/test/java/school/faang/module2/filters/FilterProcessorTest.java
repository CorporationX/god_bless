package school.faang.module2.filters;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

class FilterProcessorTest {

    @Test
    void testFilterImage() {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.name(), "%s | Фильтр: черно-белый".formatted(image.description()));
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.name(), "%s | Фильтр: сепия".formatted(image.description()));

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description());
    }

}
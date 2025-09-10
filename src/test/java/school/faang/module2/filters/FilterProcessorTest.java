package school.faang.module2.filters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

class FilterProcessorTest {

    @Test
    void testFilterImage() {
        String imageDescription = "Оригинальное изображение";
        String grayscaleFilterMark = "Фильтр: черно-белый";
        String sepiaFilterMark = "Фильтр: сепия";
        Image originalImage = new Image("original.jpg", imageDescription);

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.name(), "%s | %s".formatted(image.description(), grayscaleFilterMark));
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.name(), "%s | %s".formatted(image.description(), sepiaFilterMark));

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Assertions.assertEquals(
                "%s | %s".formatted(imageDescription, grayscaleFilterMark),
                grayscaleImage.description()
        );

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        Assertions.assertEquals(
                "%s | %s | %s".formatted(imageDescription, grayscaleFilterMark, sepiaFilterMark),
                sepiaImage.description()
        );

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        Assertions.assertEquals(
                "%s | %s | %s".formatted(imageDescription, grayscaleFilterMark, sepiaFilterMark),
                combinedImage.description()
        );
    }

}
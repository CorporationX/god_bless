package school.faang.task_46393;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FilterProcessorTest {
    private FilterProcessor filterProcessor;
    private Image image;

    @BeforeEach
    void setUp() {
        filterProcessor = new FilterProcessor();
        image = new Image("original.jpg", "Оригинальное изображение");
    }

    @Test
    void testApplyFilter() {
        Function<Image, Image> sepiaFilter = (image ->
                new Image(image.name(), image.description() + " | Фильтр: сепия"));
        Function<Image, Image> grayscaleFilter = (image ->
                new Image(image.name(), image.description() + " | Фильтр: черно-белый"));

        Image sepiaImage = filterProcessor.applyFilter(image, sepiaFilter);
        Image grayscaleSepiaImage = filterProcessor.applyFilter(sepiaImage, grayscaleFilter);

        String expectedDescription = image.description() + " | Фильтр: сепия"
                + " | Фильтр: черно-белый";
        assertEquals(expectedDescription, grayscaleSepiaImage.description());
    }

    @Test
    void testCombineFilters() {
        Function<Image, Image> sepiaFilter = (image ->
                new Image(image.name(), image.description() + " | Фильтр: сепия"));
        Function<Image, Image> grayscaleFilter = (image ->
                new Image(image.name(), image.description() + " | Фильтр: черно-белый"));

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, grayscaleFilter);
        Image actualImage = combinedFilter.apply(image);

        String expectedDescription = image.description() + " | Фильтр: сепия"
                + " | Фильтр: черно-белый";
        assertNotNull(actualImage);
        assertEquals(expectedDescription, actualImage.description());
    }
}
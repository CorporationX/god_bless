package faang.school.godbless.sprint3.task9;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {

    @Test
    void testApplyFilter() {
        Image expected = new Image("original.jpg_grayscale", "Фильтр: черно-белый");
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        FilterProcessor filterProcessor = new FilterProcessor();

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);

        assertEquals(expected, grayscaleImage);
    }

    @Test
    void testCombineFilters() {
        Image expected = new Image("original.jpg_grayscale_sepia", "Фильтр: сепия");
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        assertEquals(expected, combinedImage);
    }

    @Test
    void testApplyFilterValidationImageIsNull() {
        FilterProcessor filterProcessor = new FilterProcessor();
        assertThrows(NullPointerException.class, () -> filterProcessor.applyFilter(null,
                (i) -> new Image(i.getName() + "_grayscale", "Фильтр: черно-белый")));
    }

    @Test
    void testApplyFilterValidationFunctionIsNull() {
        FilterProcessor filterProcessor = new FilterProcessor();
        assertThrows(NullPointerException.class, () -> filterProcessor.applyFilter(new Image("1", "1"), null));
    }

    @Test
    void testCombineFilterValidationFunctionIsNull() {
        FilterProcessor filterProcessor = new FilterProcessor();
        assertThrows(NullPointerException.class, () -> filterProcessor.combineFilters(null, null));
    }
}
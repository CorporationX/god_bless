package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProcessorTest {
    Image originalImage;
    FilterProcessor filterProcessor;
    Function<Image, Image> grayscaleFilter;
    Function<Image, Image> sepiaFilter;

    @BeforeEach
    void setUp() {
        originalImage = new Image("original", "Оригинальное изображение");
        filterProcessor = new FilterProcessor();
        grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
    }

    @Test
    void testApplyFilter() {
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);

        assertEquals(grayscaleImage.getName(), "original_grayscale");
        assertEquals(sepiaImage.getName(), "original_sepia");
    }

    @Test
    void combineFilters() {
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        assertEquals(combinedImage.getName(), "original_grayscale_sepia");
    }
}
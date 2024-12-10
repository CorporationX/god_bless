package school.faang.sprint_2.task_43532;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {
    Image image;
    FilterProcessor filterProcessor;
    Function<Image, Image> grayscaleFilter;
    Function<Image, Image> sepiaFilter;

    @BeforeEach
    void setUp() {
        filterProcessor = new FilterProcessor();
        image = new Image("original.jpg", "Оригинальное изображение");
        grayscaleFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: черно-белый");
        sepiaFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: сепия");
    }

    @Test
    void givenImage_whenApplyFilter_thenReturnFilteredImage() {
        Image filteredImage = filterProcessor.applyFilter(image, grayscaleFilter);
        assertEquals("Оригинальное изображение | Фильтр: черно-белый", filteredImage.description());
    }

    @Test
    void givenImage_whenApplyTwoFilters_thenReturnTwiceFilteredImage() {
        Image filteredImage = filterProcessor.applyFilter(image, grayscaleFilter);
        Image twiceFilteredImage = filterProcessor.applyFilter(filteredImage, sepiaFilter);
        assertEquals("Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия",
                twiceFilteredImage.description());
    }

    @Test
    void givenImage_whenApplyCombineFilters_thenReturnMultipleFilteredImage() {
        Function<Image, Image> combineFilter = filterProcessor.combineFilters(sepiaFilter, grayscaleFilter);
        Image combineFilteredImage = filterProcessor.applyFilter(image, combineFilter);
        assertEquals("Оригинальное изображение | Фильтр: сепия | Фильтр: черно-белый",
                combineFilteredImage.description());
    }
}
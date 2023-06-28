package faang.school.godbless;

import faang.school.godbless.sprint2.instagram.FilterProcessor;
import faang.school.godbless.sprint2.instagram.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;

public class FilterProcessorTest {
    Image originalImage;
    FilterProcessor filterProcessor;
    Function<Image, Image> grayscaleFilter;
    Function<Image, Image> combinedFilter;
    Function<Image, Image> sepiaFilter;

    @BeforeEach
    public void init() {
        originalImage = new Image("original.jpg", "Оригинальное изображение");
        filterProcessor = new FilterProcessor();
        sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
    }
    @Test
    public void testFilters() {
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        String expected ="original.jpg_grayscale";
        assertEquals(expected, grayscaleImage.getName());
    }
    @Test
    public void testDoubleFilters(){
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        String expected  = "original.jpg_grayscale_sepia";
        assertEquals(expected ,combinedImage.getName());
    }


}

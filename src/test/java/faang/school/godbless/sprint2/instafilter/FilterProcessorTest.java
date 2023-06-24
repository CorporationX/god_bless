package faang.school.godbless.sprint2.instafilter;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProcessorTest {
    @Test
    void filterTest() {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

// Применение фильтров
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

//      asserts:
        assertEquals("original.jpg_grayscale_sepia", combinedImage.getName());
        assertEquals("Фильтр: сепия", combinedImage.getDescription());
        assertEquals("original.jpg_vignette", vignetteImage.getName());
        assertEquals("Фильтр: виньетка", vignetteImage.getDescription());
    }

}
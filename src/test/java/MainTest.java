import faang.school.godbless.filtersInstagram.FilterProcessor;
import faang.school.godbless.filtersInstagram.Image;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    Image originalImage = new Image("original.jpg", "Оригинальное изображение");

    FilterProcessor filterProcessor = new FilterProcessor();

    // Создание фильтров
    Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getNameFile() + "_grayscale", "Фильтр: черно-белый");
    Function<Image, Image> sepiaFilter = (image) -> new Image(image.getNameFile() + "_sepia", "Фильтр: сепия");
    Function<Image, Image> vignetteFilter = (image) -> new Image(image.getNameFile() + "_vignette", "Фильтр: виньетка");

    // Применение фильтров
    Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
    Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
    Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

    // Создание и применение комбинированного фильтра
    Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

    // приминенине обычного фильтра на фотку с комбинированным фильтром
    Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

    @Test
    public void testFilters() {
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        String expected = "original.jpg_grayscale";
        assertEquals(expected, grayscaleImage.getNameFile());
    }

    @Test
    public void testCombinedFilter() {
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        String expected = "original.jpg_grayscale_sepia";
        assertEquals(expected, combinedImage.getNameFile());
    }
}
